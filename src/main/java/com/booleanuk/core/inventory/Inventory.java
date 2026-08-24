package com.booleanuk.core.inventory;

import java.util.HashMap;
import java.util.Map;

import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;
import com.booleanuk.core.model.Item;

public class Inventory implements Stock {
    private Map<String, Item> stockedItems;

    public Inventory() {
        stockedItems = new HashMap<>();
    }

    public boolean hasItem(String SKU) {
        return stockedItems.containsKey(SKU);
    }

    public Item getStockItem(String SKU) {
        return stockedItems.get(SKU);
    }

    public void addItemToInventory(Item item) {
        stockedItems.put(item.getSKU(), item);
    }

    public Item createItem(String SKU) {
        Item item = stockedItems.get(SKU);

        if (item == null)
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");

        return item.createCopy();
    }

    public Filling createFilling(String SKU) {
        Item item = stockedItems.get(SKU);

        if (item == null)
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");

        if (!(item instanceof Filling))
            throw new IllegalArgumentException("Item is not a filling.");

        return (Filling) item.createCopy();
    }

}
