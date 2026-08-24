package com.booleanuk.core.model;

public abstract class Item {
    private String SKU;
    private double basePrice;
    private double totalPrice;
    private String name;
    private String variant;

    public Item(String SKU, double price, String name, String variant) {
        this.SKU = SKU;
        this.basePrice = price;
        this.totalPrice = price;
        this.name = name;
        this.variant = variant;
    }

    public abstract Item createCopy();

    public String getSKU() {
        return this.SKU;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public double getTotalPrice() {
        return this.getTotalPrice();
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }
}
