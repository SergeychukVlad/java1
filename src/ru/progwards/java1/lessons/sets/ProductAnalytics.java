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
        Set<Product> allProducts = new HashSet<>(Set.of());
        for (Shop nextShop : shops) {
            allProducts.addAll(nextShop.getProducts());
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

    public static void printProducts(Set<Product> products) {
        for (Product product : products) {
            System.out.println(product.getCode());
        }
        System.out.println(" --- ");
    }

    public static void main(String[] args) {
        List<Product> products = List.of(new Product("хлеб"), new Product("молоко"), new Product("сахар"),
                new Product("гвозди"), new Product("брезент"), new Product("топор"),
                new Product("розетка"), new Product("выключатель"), new Product("вилка"));

        Shop shop1 = new Shop(List.of(new Product("хлеб"), new Product("молоко"), new Product("гвозди")));
        Shop shop2 = new Shop(List.of(new Product("розетка"), new Product("гвозди"), new Product("вилка")));
        Shop shop3 = new Shop(List.of(new Product("хлеб"), new Product("брезент"), new Product("топор")));
        List<Shop> shops = List.of(shop1, shop2, shop3);

        ProductAnalytics analytics = new ProductAnalytics(products, shops);
        Set<Product> allProducts = analytics.existInAll();
        printProducts(allProducts);
    }
}
