package com.booleanuk.core;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Basket;

public class BobsBagels {
    private Inventory bobsInventory;

    public BobsBagels() {
        bobsInventory = new Inventory();
    }

    public void addItemToBasket(String SKU, Basket basket) {
        if (bobsInventory.isAvailable(SKU)) {
            basket.add(bobsInventory.createItem(SKU));
        } else {
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");
        }
    }

    public void addFillingToBagel(String SKU, Bagel bagel) {
        if (bobsInventory.isAvailable(SKU)) {
            bagel.addFilling(bobsInventory.createFilling(SKU));
        } else {
            throw new IllegalArgumentException("Bob's Bagels does not stock that item.");
        }
    }
}
