package com.booleanuk.core;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Filling;

import org.junit.jupiter.api.Assertions;

public class BagelTest {
    Inventory bobsInventory;
    Bagel onionBagel;
    Filling egg;
    Filling bacon;

    BagelTest() {
        //onionBagel = new Bagel("BGLO", 0.49, "Onion");
        //eggFilling = new Filling("FILE", 0.12, "Egg");
        bobsInventory = new Inventory();
        onionBagel = new Bagel("BGLO", 0.49, "Onion");
        egg = new Filling("FILE", 0.12, "Egg");
        bacon = new Filling("FILB", 0.12, "Bacon");
    }

    @Test
    void newBagel_hasNoFillings() {
        Assertions.assertTrue(onionBagel.getFillings().isEmpty());
    }

    // add filling
    @Test
    void addFilling_eggOnionBagel() {
        onionBagel.addFilling(egg);

        List<Filling> expected = List.of(egg);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);
    }

    // add multiple fillings 
    @Test
    void addTwoFillings_eggAndBaconOnionBagel() {
        onionBagel.addFilling(egg);
        onionBagel.addFilling(bacon);

        List<Filling> expected = List.of(egg, bacon);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);
    }

    // add multiple of the same Filling
    @Test
    void addTwoFillings_doubleBaconOnionBagel() {
        onionBagel.addFilling(bacon);
        onionBagel.addFilling(bacon);

        List<Filling> expected = List.of(bacon, bacon);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);
    }

    // remove filling that doesn't exist - error
    @Test
    void removeFilling_noFillingExists_IllegalArgumentException() {
        onionBagel.removeFilling(bacon);

        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> onionBagel.removeFilling(bacon));
    }

    // remove filling
    @Test
    void addAndRemoveFilling_fillingIsAddedAndRemoved() {
        onionBagel.addFilling(bacon);

        List<Filling> expected = List.of(bacon);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);

        onionBagel.removeFilling(bacon);

        Assertions.assertTrue(onionBagel.getFillings().isEmpty());
    }

    // get total cost: bagel + two fillings
    @Test
    void getTotalCost_bagelWithTwoFillings_0p73() {
        onionBagel.addFilling(egg);
        onionBagel.addFilling(bacon);

        double expected = 0.49 + 0.12 + 0.12;
        double actual = onionBagel.getTotalCost();

        Assertions.assertEquals(expected, actual);
    }

    /*// get name of bagel + one filling
    @Test
    void getFullName_onionBagelWithEgg() {
        onionBagel.addFilling(egg);

        String expected = "Onion bagel with egg";
        String actual = onionBagel.getFullName();

        Assertions.assertEquals(expected, actual);
    }*/
}
