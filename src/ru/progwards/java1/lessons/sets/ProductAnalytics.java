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
    private Set<Product> products_existInAll = new HashSet<>();

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> result = new HashSet<>(products);
        for (Shop nextShop : shops)
            result.retainAll(nextShop.getProducts());
        return result;
    }

    public Set<Product> existAtListInOne() {
        Set<Product> result = new HashSet<>();
        for (Shop nextShop : shops)
            result.addAll(nextShop.getProducts());
        return result;
    }

    public Set<Product> notExistInShops() {
        Set<Product> result = new HashSet<>(products);
        for (Shop nextShop : shops)
            products_existInAll.addAll(nextShop.getProducts());

        result.removeAll(products_existInAll);
        return result;
    }

    public Set<Product> existOnlyInOne() {
        products_existInAll.clear();
        for (Shop nextShop : shops)
            products_existInAll.addAll(nextShop.getProducts());

        Set<Product> result = new HashSet<>(products_existInAll);
        Set<Product> intersection = new HashSet<>();

        for (Shop nextShop : shops) {
            if (intersection.isEmpty()) {
                intersection.addAll(nextShop.getProducts());
            } else {
                intersection.retainAll(nextShop.getProducts());
                result.removeAll(intersection);
            }
            if (result.size() == products_existInAll.size()) {
                result.removeAll(nextShop.getProducts());
            }
        }
        return result;
    }

    public static void printProducts(Set<Product> products) {
        for (Product product : products) {
            System.out.println(product.getCode());
        }
        System.out.println(" --- ");
    }

    public static void main(String[] args) {
        Product prod1 = new Product("хлеб");
        Product prod2 = new Product("молоко");
        Product prod3 = new Product("сахар");
        Product prod4 = new Product("гвозди");
        Product prod5 = new Product("брезент");
        Product prod6 = new Product("топор");
        Product prod7 = new Product("розетка");
        Product prod8 = new Product("выключатель");
        Product prod9 = new Product("вилка");
        Product prod10 = new Product("соль");
        List<Product> products = List.of(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9);
        List<Product> products2test = List.of(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10);

        Shop shop1 = new Shop(List.of(prod2, prod3, prod5, prod7, prod8));
        Shop shop2 = new Shop(List.of(prod3, prod5, prod8, prod10));
        Shop shop3 = new Shop(List.of(prod1, prod4, prod6, prod7, prod10));
        List<Shop> shops = List.of(shop1, shop2, shop3);
        List<Shop> shops2test = List.of(shop1, shop2);

        ProductAnalytics analytics = new ProductAnalytics(products2test, shops);

        printProducts(analytics.existInAll());
        printProducts(analytics.existAtListInOne());
        printProducts(analytics.notExistInShops());
        printProducts(analytics.existOnlyInOne());
    }
}
