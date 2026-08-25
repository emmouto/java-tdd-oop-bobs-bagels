package com.booleanuk.core;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.Stock;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InventoryTest {
    Inventory bobsInventory;

    InventoryTest() {
        bobsInventory = new Inventory();

        bobsInventory.addProductToInventory(new Bagel("BGLO", 0.49, "Onion"));
        bobsInventory.addProductToInventory(new Bagel("BGLP", 0.39, "Plain"));
        bobsInventory.addProductToInventory(new Bagel("BGLE", 0.49, "Everything"));
        bobsInventory.addProductToInventory(new Bagel("BGLS", 0.49, "Sesame"));

        bobsInventory.addProductToInventory(new Coffee("COFB", 0.99, "Black"));
        bobsInventory.addProductToInventory(new Coffee("COFW", 1.19, "White"));
        bobsInventory.addProductToInventory(new Coffee("COFC", 1.29, "Capuccino"));
        bobsInventory.addProductToInventory(new Coffee("COFL", 1.29, "Latte"));

        bobsInventory.addProductToInventory(new Filling("FILB", 0.12, "Bacon"));
        bobsInventory.addProductToInventory(new Filling("FILE", 0.12, "Egg"));
        bobsInventory.addProductToInventory(new Filling("FILC", 0.12, "Cheese"));
        bobsInventory.addProductToInventory(new Filling("FILX", 0.12, "Cream Cheese"));
        bobsInventory.addProductToInventory(new Filling("FILS", 0.12, "Smoked Salmon"));
        bobsInventory.addProductToInventory(new Filling("FILH", 0.12, "Ham"));
    }

    // SKU for Everything Bagel ("BGLE") should be in the inventory
    @Test
    void hasItem_skuBGLE_true() {
        Assertions.assertTrue(bobsInventory.hasProduct("BGLE"));
    }
    
    @Test
    void hasItem_injectedSKU_true() {
        Stock testStock = sku -> sku.equals("BGLP");
        Assertions.assertTrue(testStock.hasProduct("BGLP"));
    }

    // SKU BGLX should not exist
    @Test
    void hasItem_skuBGLX_false() {
        Assertions.assertFalse(bobsInventory.hasProduct("BGLX"));
    }
}
