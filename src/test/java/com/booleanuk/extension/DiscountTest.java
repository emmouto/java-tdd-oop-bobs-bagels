package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Basket;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;
import com.booleanuk.extension.discount.PriceCalculator;

import org.junit.jupiter.api.Assertions;

public class DiscountTest {
    Basket basket;
    Inventory bobsInventory;

    DiscountTest() {
        bobsInventory = new Inventory();

        bobsInventory.addProductToInventory(new Bagel("BGLO", 0.49, "Onion"));
        bobsInventory.addProductToInventory(new Coffee("COFB", 0.99, "Black"));
        bobsInventory.addProductToInventory(new Filling("FILC", 0.12, "Cheese"));

        basket = new Basket(19, bobsInventory);
    }

    @Test
    void applyMultiPriceDiscount_6BagelsFor2p49() {
        for (int i = 0; i < 6; i++) {
            basket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        PriceCalculator priceCalculator = new PriceCalculator();
        double actual = priceCalculator.calculate(basket);

        Assertions.assertEquals(2.49, actual);
    }

    @Test
    void applyMultiPriceDiscount_6BagelsFor2p49Plus3FillingsAtNormalPrice() {
        for (int i = 0; i < 5; i++) {
            basket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        Bagel bagelWithFillings = new Bagel("BGLO", 0.49, "Everything");

        for (int i = 0; i < 5; i++) {
            bagelWithFillings.addFilling(new Filling("FILC", 0.12, "Cheese"));
        }

        basket.add(bagelWithFillings);

        PriceCalculator priceCalculator = new PriceCalculator();
        double actual = priceCalculator.calculate(basket);

        Assertions.assertEquals(2.85, actual);
    }

    @Test
    void applyMultiPriceDiscount_12BagelsFor3p99() {
        for (int i = 0; i < 12; i++) {
            basket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        double actual = basket.getTotalPrice(); // applies discount

        Assertions.assertEquals(3.99, actual);
    }

    @Test
    void applyMultiPriceDiscount_7BagelsAppliesDiscountFor6AndOneHasNormalPrice() {
        for (int i = 0; i < 7; i++) {
            basket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        double actual = basket.getTotalPrice(); // applies discount

        Assertions.assertEquals(4.48, actual);
    }

    @Test
    void applyMultiPriceDiscount_18BagelsRequiresTwoSpecialOffersCombined() {
        for (int i = 0; i < 18; i++) {
            basket.add(new Bagel("BGLO", 0.49, "Onion"));
        }

        double actual = basket.getTotalPrice(); // applies discount

        Assertions.assertEquals(6.48, actual);
    }

    @Test
    void applyComboDeal_coffeeAndBagelFor1p25() {
        basket.add(new Bagel("BGLO", 0.49, "Onion"));
        basket.add(new Coffee("COFB", 0.99, "Black"));

        double actual = basket.getTotalPrice(); // applies discount

        Assertions.assertEquals(1.25, actual);
    }
}
