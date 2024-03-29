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
        Set<Product> productsAllShops = new HashSet<>();

        for (Shop nextShop : shops)
            productsAllShops.addAll(nextShop.getProducts());

        Set<Product> result = new HashSet<>(products);
        result.removeAll(productsAllShops);

        return result;
    }

    public Set<Product> existOnlyInOne() {
        Set<Product> result = new HashSet<>();
        Set<Product> intersection = new HashSet<>();

        int i = 0;
        for (Shop shop : shops) {
            result.addAll(shop.getProducts());
//  Set result собирает товары из всех магазинов
            if (i == shops.size() - 1) {
                intersection.retainAll(shop.getProducts());
            } else {
                intersection.addAll(shop.getProducts());
            }
//  одновременно Set intersection собирает пересечения товаров сравниваемых shop
//  (вариант, когда наборы товаров не имеют пересечений)

            i++;
        }
        Set<Product> sumIntersection = new HashSet<>(intersection);
//  в Set sumIntersection кладём найденные пересечения после прохода по shops
        i = 0;
        intersection.clear();
        for (Shop shop : shops) {
            if (i == 1) {
                intersection.retainAll(shop.getProducts());
                break;
            } else
                intersection.addAll(shop.getProducts());
            i++;
        }
//  а этим новым проходом по shops Set intersection собирает пересечения товаров в магазинах
//  (вариант, когда наборы товаров имеют пересечения)
//  найденным пополняем sumIntersection
        sumIntersection.addAll(intersection);
//  из набора товаров, которые есть в магазинах, вычитаем набор всех пересечений
        result.removeAll(sumIntersection);
        return result;
    }

    public static void main(String[] args) {
        Product prod1 = new Product("п1");
        Product prod2 = new Product("п2");
        Product prod3 = new Product("п3");
        Product prod4 = new Product("п4");
        Product prod5 = new Product("п5");
        Product prod6 = new Product("п6");
        Product prod7 = new Product("п7");
        Product prod8 = new Product("п8");
        Product prod9 = new Product("п9");
        Product prod10 = new Product("п10");
        List<Product> products2test = List.of(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10);

        Shop shop1 = new Shop(List.of(prod1, prod6, prod7, prod9, prod10));
        Shop shop2 = new Shop(List.of(prod1, prod2, prod7, prod8));
        Shop shop3 = new Shop(List.of(prod1, prod4, prod9, prod10));
        List<Shop> shops = List.of(shop1, shop2, shop3);

        ProductAnalytics analytics = new ProductAnalytics(products2test, shops);

        analytics.existInAll();
        analytics.existAtListInOne();
        analytics.notExistInShops();
        analytics.existOnlyInOne();
    }
}
