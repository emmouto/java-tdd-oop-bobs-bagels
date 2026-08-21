package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Filling;

import org.junit.jupiter.api.Assertions;

public class ItemTest {
    Inventory bobsInventory;
    Bagel onionBagel;
    Filling egg;

    ItemTest() {
        onionBagel = new Bagel("BGLO", 0.49, "Onion");
        egg = new Filling("FILE", 0.12, "Egg");
        bobsInventory = new Inventory();
        //onionBagel = new Bagel("BGLO");
        //egg = new Filling("FILE");
    }

    /*@Test
    void givenName_createOnionBagel() {
        onionBagel = new Bagel("Onion");
    }

    @Test
    void givenSKU_createEggFilling() {
        eggFilling = new Filling("FILE");
    }*/

    // get SKU of bagel
    @Test
    void getSKU_returnBagelSKU_BGLO() {
        Assertions.assertEquals("BGLO", onionBagel.getSKU());
    }

    // get price of filling
    @Test
    void getPrice_filling_0p12() {
        Assertions.assertEquals(0.12, egg.getPrice());
    }

    // get name of bagel
    @Test
    void getName_bagel() {
        Assertions.assertEquals("Bagel", onionBagel.getName());
    }

    // get variant name
    @Test
    void getVariant_bagel_onion() {
        Assertions.assertEquals("Onion", onionBagel.getVariant());
    }
}
