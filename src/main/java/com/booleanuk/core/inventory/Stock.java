package com.booleanuk.core.inventory;

@FunctionalInterface
public interface Stock {
    public boolean hasItem(String sku);
}
