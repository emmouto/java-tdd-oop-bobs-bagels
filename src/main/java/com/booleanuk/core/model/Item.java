package com.booleanuk.core.model;

public abstract class Item extends Product {
    public Item(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
    }

    public double getTotalPrice() {
        return getBasePrice();
    }
    
    public abstract Item createCopy();
}
