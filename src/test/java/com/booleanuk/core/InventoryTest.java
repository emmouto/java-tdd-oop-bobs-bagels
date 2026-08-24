package com.booleanuk.core;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InventoryTest {
    Inventory bobsInventory;

    public InventoryTest() {
        bobsInventory = new Inventory();
        
        bobsInventory.addItemToInventory(new Bagel("BGLE", 0.49, "Everything"));
    }

    // SKU for Everything Bagel ("BGLE") should be in the inventory list
    @Test
    public void hasItem_skuBGLE_true() {
        Assertions.assertTrue(bobsInventory.hasItem("BGLE"));
    }

    // SKU BGLX should not exist
    @Test
    public void hasIteme_skuBGLX_false() {
        Assertions.assertFalse(bobsInventory.hasItem("BGLX"));
    }
}
