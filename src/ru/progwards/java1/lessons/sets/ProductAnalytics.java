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
        Set<Product> allProducts = new TreeSet<>(products);
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
        Product aa = new Product("хлеб");
        Product ab = new Product("молоко");
        Product ba = new Product("сахар");
        Product bb = new Product("соль");
        List<Product> productsProd = List.of(aa, ab, ba, bb);

        Product ee = new Product("гвозди");
        Product ef = new Product("брезент");
        Product fe = new Product("топор");
        Product ff = new Product("пила");
        List<Product> productsProm = List.of(ee, ef, fe, ff);

        Product yy = new Product("гвозди");
        Product yz = new Product("брезент");
        Product zy = new Product("топор");
        Product zz = new Product("пила");
        List<Product> productsLux = List.of(yy, yz, zy, zz);

        Shop shopProd = new Shop(productsProd);
        Shop shopProm = new Shop(productsProm);
        Shop shopLux = new Shop(productsLux);
        List<Shop> shopList = List.of(shopProd, shopProm, shopLux);
        ProductAnalytics analytics = new ProductAnalytics(productsProd, shopList);
//        System.out.println(analytics.existInAll());
    }
}
