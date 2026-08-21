package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import com.booleanuk.core.inventory.Inventory;

import org.junit.jupiter.api.Assertions;

public class InventoryTest {
    Inventory bobsInventory;

    public InventoryTest() {
        bobsInventory = new Inventory(); // all skus should be added to inventory at construction
    }

    // SKU for Everything Bagel ("BGLE") should be in the inventory list
    @Test
    public void isAvailable_skuBGLE_true() {
        Assertions.assertTrue(bobsInventory.isAvailable("BGLE"));
    }

    // SKU BGLX should not exist
    @Test
    void isAvailable_skuBGLX_false() {
        Assertions.assertFalse(bobsInventory.isAvailable("BGLX"));
    }
}
