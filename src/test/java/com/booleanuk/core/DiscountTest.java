package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DiscountTest {
    Inventory bobsInventory;
    Basket emmasBasket;

    DiscountTest() {
        bobsInventory = new Inventory();
        emmasBasket = new Basket(19);
    }

    @Test
    void applyMultiPriceDiscount_6BagelsFor2p49() {
        for (int i = 0; i < 6; i++) {
            emmasBasket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        double actual = emmasBasket.getTotalCost(); // applies discount

        Assertions.assertEquals(2.49, actual);
    }

    @Test
    void applyMultiPriceDiscount_6BagelsFor2p49Plus3FillingsAtNormalPrice() {
        for (int i = 0; i < 5; i++) {
            emmasBasket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        Bagel bagelWithFillings = new Bagel("BGLO", 0.49, "Everything");

        for (int i = 0; i < 5; i++) {
            bagelWithFillings.addFilling(new Filling("FILC", 0.12, "Cheese"));
        }

        emmasBasket.add(bagelWithFillings);

        double actual = emmasBasket.getTotalCost(); // applies discount

        Assertions.assertEquals(2.49, actual);
    }

    @Test
    void applyMultiPriceDiscount_12BagelsFor3p99() {
        for (int i = 0; i < 12; i++) {
            emmasBasket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        double actual = emmasBasket.getTotalCost(); // applies discount

        Assertions.assertEquals(3.99, actual);
    }

    @Test
    void applyMultiPriceDiscount_7BagelsAppliesDiscountFor6AndOneHasNormalPrice() {
        for (int i = 0; i < 7; i++) {
            emmasBasket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        double actual = emmasBasket.getTotalCost(); // applies discount

        Assertions.assertEquals(3.99, actual);
    }

    @Test
    void applyMultiPriceDiscount_18BagelsRequiresTwoSpecialOffersCombined() {
        for (int i = 0; i < 18; i++) {
            emmasBasket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        double actual = emmasBasket.getTotalCost(); // applies discount

        Assertions.assertEquals(3.99, actual);
    }

    @Test
    void applyComboDeal_coffeeAndBagelFor1p25() {
        emmasBasket.add(new Bagel("BGLO", 0.49, "Onion"));
        emmasBasket.add(new Coffee("COFB", 0.99, "Black"));

        double actual = emmasBasket.getTotalCost(); // applies discount

        Assertions.assertEquals(3.99, actual);
    }
}
