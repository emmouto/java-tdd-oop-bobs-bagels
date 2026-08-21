package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Inventory
 */
public class Inventory {
    Map<String, Item> stock;

    public Inventory() {
        stock = new HashMap<>();
        stock.put("BGLO", new Bagel("BGLO", 0.49, "Onion"));
        stock.put("BGLP", new Bagel("BGLO", 0.39, "Plain"));
        stock.put("BGLE", new Bagel("BGLO", 0.49, "Everything"));
        stock.put("BGLS", new Bagel("BGLO", 0.49, "Sesame"));
    }

    public boolean isAvailable(String SKU) {
        return stock.containsKey(SKU);
    }

}
