package com.booleanuk.core;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InventoryTest {
    Inventory bobsInventory;

    public InventoryTest() {
        bobsInventory = new Inventory(); // all skus should be added to inventory at construction
    }

    @Test
    public void isAvailable_skus_BGLE() {
        Assertions.assertTrue(bobsInventory.isAvailable("BGLE"));
    }
}
