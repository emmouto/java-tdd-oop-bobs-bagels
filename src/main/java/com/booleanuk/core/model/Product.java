package com.booleanuk.core.model;

public abstract class Product {
    private String SKU;
    private double basePrice;
    private String name;
    private String variant;

    public Product(String SKU, double price, String name, String variant) {
        this.SKU = SKU;
        this.basePrice = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSKU() {
        return this.SKU;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }

    //public abstract Product createCopy();
}
