package com.booleanuk.core.model;

public abstract class AddOn extends Product {
    public AddOn(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
    }
}
