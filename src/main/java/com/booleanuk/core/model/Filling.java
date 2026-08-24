package com.booleanuk.core.model;

public class Filling extends Item {
    public Filling(String SKU, double price, String variant) {
        super(SKU, price, "Filling", variant);
    }

    @Override
    public Filling createCopy() {
        return new Filling(getSKU(), getBasePrice(), getVariant());
    }
}
