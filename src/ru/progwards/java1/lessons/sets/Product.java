package ru.progwards.java1.lessons.sets;

public class Product {

    private String code;
    public Product(String code) {
        this.code = code;
    }

    public String getCode() {
        if (code != null) return code;
        else return "данный код не существует";
    }
}
