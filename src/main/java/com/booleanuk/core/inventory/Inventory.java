package com.booleanuk.core.inventory;

import java.util.HashMap;
import java.util.Map;

import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;
import com.booleanuk.core.model.Item;

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

        stock.put("COFB", new Coffee("COFB", 0.99, "Black"));
        stock.put("COFW", new Coffee("COFW", 1.19, "White"));
        stock.put("COFC", new Coffee("COFC", 1.29, "Capuccino"));
        stock.put("COFL", new Coffee("COFL", 1.29, "Latte"));

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

    public Item createItem(String SKU) {
        Item item = stock.get(SKU);

        if (item == null)
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");

        return item.createCopy();
    }

    public Filling createFilling(String SKU) {
        Item item = stock.get(SKU);

        if (item == null)
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");

        if (!(item instanceof Filling))
            throw new IllegalArgumentException("Item is not a filling.");

        return (Filling) item.createCopy();
    }

}
