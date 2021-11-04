/*
2.1 Создать класс Product - товар,
2.2. Создать private String code - уникальный артикул товара
2.3 Создать конструктор public Product(String code)
2.4 Метод public String getCode()

2.5 Создать класс Shop - магазин
2.6 Создать private List<Product> products - товары имеющиеся в магазине
2.7 Создать конструктор public Shop(List<Product> products)
2.8 Создать метод public List<Product> getProducts()

2.9 Создать класс ProductAnalytics
2.10 Создать private List<Shop> shops - список магазинов
2.11 Создать private List<Product> products - список всех имеющихся в ассортименте товаров.
Все товары, присутствующие в магазинах, обязательно присутствуют в products, но так же тут могут быть и товары,
которых нет в магазинах
2.12 Создать конструктор  public ProductAnalytics(List<Product> products, List<Shop> shops)
2.13 Создать функцию public Set<Product> existInAll() - товары из products, которые имеются во всех магазинах
2.14 Создать функцию public Set<Product> existAtListInOne() - товары из products, которые имеются хотя бы в одном магазине
2.15 Создать функцию public Set<Product> notExistInShops() - товары из products, которых нет ни в одном магазине
2.16 Создать функцию public Set<Product> existOnlyInOne() - товары из products, которые есть только в одном магазине
 */
package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {

    private List<Shop> shops;

    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> allProducts = null;

        for (Shop shop : shops) {
            allProducts.add((Product) shop.getProducts());
        }
        return allProducts;
    }

    public Set<Product> existAtListInOne() {
        return null;
    }

    public Set<Product> notExistInShops() {
        return null;
    }

    public Set<Product> existOnlyInOne() {
        return null;
    }

    public static void main(String[] args) {
        Product a1 = new Product("хлеб");
        Product a2 = new Product("молоко");
        Product a3 = new Product("сахар");
        Product a4 = new Product("соль");
        Shop shopProd = new Shop(List.of(a1, a2, a3, a4));

        Product b1 = new Product("гвозди");
        Product b2 = new Product("брезент");
        Product b3 = new Product("топор");
        Product b4 = new Product("пила");
        Shop shopProm = new Shop(List.of(b1, b2, b3, b4));

        Product c1 = new Product("вилка");
        Product c2 = new Product("розетка");
        Product c3 = new Product("выключатель");
        Product c4 = new Product("автомат");
        Shop shopLux = new Shop(List.of(c1, c2, c3, c4));

        List<Shop> shopList = List.of(shopProd, shopProm, shopLux);

        ListIterator<Shop> iterator = shopList.listIterator();
        List<Product> allProducts = iterator.next().getProducts();
        while(iterator.hasNext())
        {
            allProducts.addAll(iterator.next().getProducts());
        }
    }
}
