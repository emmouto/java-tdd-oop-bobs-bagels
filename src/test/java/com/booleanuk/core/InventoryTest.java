package com.booleanuk.core;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.Stock;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;

import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.Assertions;

public class InventoryTest {
    Inventory bobsInventory;

    InventoryTest() {
        bobsInventory = new Inventory();
    }

    // SKU for Everything Bagel ("BGLE") should be in the inventory list after adding it
    @Test
    void hasItem_skuBGLE_true() {
        bobsInventory.addItemToInventory(new Bagel("BGLE", 0.49, "Everything"));
        Assertions.assertTrue(bobsInventory.hasItem("BGLE"));
    }
    
    @Test
    void hasItem_injectedSKU_true() {
        Stock testStock = sku -> sku.equals("BGLP");
        Assertions.assertTrue(testStock.hasItem("BGLP"));
    }

    // SKU BGLX should not exist
    @Test
    void hasItem_skuBGLX_false() {
        Assertions.assertFalse(bobsInventory.hasItem("BGLX"));
    }
}
