package com.booleanuk.core;

public class Filling extends Item {
    public Filling(String SKU, double price, String variant) {
        super(SKU, price, "Filling", variant);
    }

    public Filling(String SKU) {
        this(SKU, 1, "test"); // TODO
    }
}
