package com.booleanuk.core.model;

public class Coffee extends Item {
    public Coffee(String SKU, double price, String variant) {
        super(SKU, price, "Coffee", variant);
    }

    @Override
    public double getTotalPrice() {
        return getBasePrice(); // coffee currently doesn't have any addons
    }

    @Override
    public Coffee createCopy() {
        return new Coffee(getSKU(), getBasePrice(), getVariant());
    }
}