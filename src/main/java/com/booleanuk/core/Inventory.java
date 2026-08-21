package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Inventory
 */
public class Inventory {
    private Map<String, Item> stock;

    public Inventory() {
        stock = new HashMap<>();
        stock.put("BGLO", new Bagel("BGLO", 0.49, "Onion"));
        stock.put("BGLP", new Bagel("BGLO", 0.39, "Plain"));
        stock.put("BGLE", new Bagel("BGLO", 0.49, "Everything"));
        stock.put("BGLS", new Bagel("BGLO", 0.49, "Sesame"));
        stock.put("FILB", new Filling("FILB", 0.12, "Bacon"));
        stock.put("FILE", new Filling("FILE", 0.12, "Egg"));
        stock.put("FILC", new Filling("FILC", 0.12, "Cheese"));
        stock.put("FILX", new Filling("FILX", 0.12, "Cream Cheese"));
        stock.put("FILS", new Filling("FILS", 0.12, "Smoked Salmon"));
        stock.put("FILH", new Filling("FILH", 0.12, "Ham"));
    }

    public boolean isAvailable(String SKU) {
        return stock.containsKey(SKU);
    }

    public Item getStockItem(String SKU) {
        return stock.get(SKU);
    }

}
