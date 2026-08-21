package com.booleanuk.core;

public abstract class Item {
    private String SKU;
    private double price;
    private String name;
    private String variant;

    public Item(String SKU, double price, String name, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSKU() {
        return this.SKU;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }
}
