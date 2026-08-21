package com.booleanuk.core;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ItemTest {
    Bagel onionBagel;
    Filling eggFilling;

    ItemTest() {
        //onionBagel = new Bagel("BGLO", 0.49, "Onion");
        //eggFilling = new Filling("FILE", 0.12, "Egg");
        onionBagel = new Bagel("BGLO");
        eggFilling = new Filling("FILE");
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
        Assertions.assertEquals(0.12, eggFilling.getPrice());
    }

    // get name of bagel
    @Test
    void getName_bagel() {
        Assertions.assertEquals("Bagel", onionBagel.getName());
    }

    // get variant name
    @Test
    void getVariant_bagel_onion() {
        Assertions.assertEquals("Onion", onionBagel.getName());
    }
}
