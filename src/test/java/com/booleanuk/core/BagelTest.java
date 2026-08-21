package com.booleanuk.core;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BagelTest {
    Bagel onionBagel;
    Filling eggFilling;
    Filling baconFilling;

    BagelTest() {
        //onionBagel = new Bagel("BGLO", 0.49, "Onion");
        //eggFilling = new Filling("FILE", 0.12, "Egg");
        onionBagel = new Bagel("BGLO");
        eggFilling = new Filling("FILE");
        baconFilling = new Filling("FILB");
    }

    @Test
    void newBagel_hasNoFillings() {
        Assertions.assertTrue(onionBagel.getFillings().isEmpty());
    }

    // add filling
    @Test
    void addFilling_eggOnionBagel() {
        onionBagel.addFilling(eggFilling);

        List<Filling> expected = List.of(eggFilling);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);
    }

    // add multiple fillings 
    @Test
    void addTwoFillings_eggAndBaconOnionBagel() {
        onionBagel.addFilling(eggFilling);
        onionBagel.addFilling(baconFilling);

        List<Filling> expected = List.of(eggFilling, baconFilling);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);
    }

    // add multiple of the same Filling
    @Test
    void addTwoFillings_doubleBaconOnionBagel() {
        onionBagel.addFilling(baconFilling);
        onionBagel.addFilling(baconFilling);

        List<Filling> expected = List.of(baconFilling, baconFilling);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);
    }

    // remove filling that doesn't exist - error
    @Test
    void removeFilling_noFillingExists_error() {
        onionBagel.removeFilling(baconFilling);

        Assertions.assertThrows(IllegalArgumentException, 
            () -> bagel.removeFilling(baconFilling));
    }

    // remove filling
    @Test
    void addAndRemoveFilling_fillingIsAddedAndRemoved() {
        onionBagel.addFilling(baconFilling);

        List<Filling> expected = List.of(baconFilling);
        List<Filling> actual = onionBagel.getFillings();

        Assertions.assertEquals(expected, actual);

        onionBagel.removeFilling(baconFilling);

        Assertions.assertTrue(onionBagel.getFillings().isEmpty());
    }

    // get total cost: bagel + two fillings
    @Test
    void getTotalCost_bagelWithTwoFillings_0p73() {
        onionBagel.addFilling(eggFilling);
        onionBagel.addFilling(baconFilling);

        double expected = 0.49 + 0.12 + 0.12;
        double actual = onionBagel.getTotalCost();

        Assertions.assertEquals(expected, actual);
    }

    // get name of bagel + one filling
    @Test
    void getFullName_onionBagelWithEgg() {
        onionBagel.addFilling(eggFilling);

        String expected = "Onion bagel with egg"
        String actual = onionBagel.getFullName();

        Assertions.assertEquals(expected, actual);
    }
}
