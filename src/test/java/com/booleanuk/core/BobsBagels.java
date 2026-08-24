package com.booleanuk.core;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Basket;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;

public class BobsBagels {
    private Inventory bobsInventory;

    public BobsBagels() {
        bobsInventory = new Inventory();

        bobsInventory.addItemToInventory(new Bagel("BGLO", 0.49, "Onion"));
        bobsInventory.addItemToInventory(new Bagel("BGLP", 0.39, "Plain"));
        bobsInventory.addItemToInventory(new Bagel("BGLE", 0.49, "Everything"));
        bobsInventory.addItemToInventory(new Bagel("BGLS", 0.49, "Sesame"));

        bobsInventory.addItemToInventory(new Coffee("COFB", 0.99, "Black"));
        bobsInventory.addItemToInventory(new Coffee("COFW", 1.19, "White"));
        bobsInventory.addItemToInventory(new Coffee("COFC", 1.29, "Capuccino"));
        bobsInventory.addItemToInventory(new Coffee("COFL", 1.29, "Latte"));

        bobsInventory.addItemToInventory(new Filling("FILB", 0.12, "Bacon"));
        bobsInventory.addItemToInventory(new Filling("FILE", 0.12, "Egg"));
        bobsInventory.addItemToInventory(new Filling("FILC", 0.12, "Cheese"));
        bobsInventory.addItemToInventory(new Filling("FILX", 0.12, "Cream Cheese"));
        bobsInventory.addItemToInventory(new Filling("FILS", 0.12, "Smoked Salmon"));
        bobsInventory.addItemToInventory(new Filling("FILH", 0.12, "Ham"));
    }

    /* 
    public void addItemToBasket(String SKU, Basket basket) {
        if (bobsInventory.hasItem(SKU)) {
            basket.add(bobsInventory.createItem(SKU));
        } else {
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");
        }
    }

    public void addFillingToBagel(String SKU, Bagel bagel) {
        if (bobsInventory.hasItem(SKU)) {
            bagel.addFilling(bobsInventory.createFilling(SKU));
        } else {
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");
        }
    }
    */
}
