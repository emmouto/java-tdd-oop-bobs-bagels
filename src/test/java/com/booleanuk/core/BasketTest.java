package com.booleanuk.core;

import java.util.List;

import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Basket;
import com.booleanuk.core.model.Filling;
import com.booleanuk.core.model.Item;
import com.booleanuk.core.model.Role;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BasketTest {
    Basket basket;
    Inventory inventory;
    Bagel onionBagel;
    Bagel plainBagel;
    Bagel everythingBagel;
    Bagel sesameBagel;
    Filling egg;
    Filling bacon;

    BasketTest() {
        inventory = new Inventory();

        onionBagel = new Bagel("BGLO", 0.49, "Onion");
        plainBagel = new Bagel("BGLP", 0.39, "Plain");
        everythingBagel = new Bagel("BGLE", 0.49, "Everything");
        sesameBagel = new Bagel("BGLS", 0.49, "Sesame");
        egg = new Filling("FILE", 0.12, "Egg");
        bacon = new Filling("FILB", 0.12, "Bacon");

        inventory.addProductToInventory(onionBagel);
        inventory.addProductToInventory(plainBagel);
        inventory.addProductToInventory(everythingBagel);
        inventory.addProductToInventory(sesameBagel);
        inventory.addProductToInventory(egg);
        inventory.addProductToInventory(bacon);

        basket = new Basket(3, inventory);
    }

    // change capacity - manager - success
    @Test
    void changeCapacity_ifUserIsManager_success() {
        basket.changeCapacity(5, Role.MANAGER); // TODO role management

        Assertions.assertEquals(5, basket.getCapacity());
    }

    // change capacity - customer - failure
    @Test
    void changeCapacity_ifUserIsCustomer_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> basket.changeCapacity(5, Role.CUSTOMER)
        ); // TODO proper role management
    }

    // add item that doesn't exist in inventory - failure
    @Test
    void add_itemThatDoesntExistInInventory_cannotAdd() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> basket.add(new Bagel("BGLX", 3.99, "Special"))
        );
    }

    // add item that exists - success
    @Test
    void add_itemThatExistsInInventory_canAdd() {
        basket.add(onionBagel);

        List<Item> expected = List.of(onionBagel);
        List<Item> actual = basket.getContents();

        Assertions.assertEquals(expected, actual);
    }

    // basket is full after adding item and it reaches capacity
    @Test
    void basketIsFullAfterAddingItemToReachCapacity() {
        basket.add(onionBagel);
        basket.add(plainBagel);
        basket.add(sesameBagel);

        Assertions.assertTrue(basket.isFull());
    }

    // add item when basket is at capacity - failure
    @Test
    void cannotAddItemWhenBasketIsFull() {
        basket.add(onionBagel);
        basket.add(plainBagel);
        basket.add(sesameBagel);

        Assertions.assertThrows(IllegalStateException.class,
            () -> basket.add(everythingBagel));
    }

    // filling doesn't count towards capacity
    @Test
    void twoBagelsInBasketWithCapacity3_addFillingDoesntMakeBasketFull() {
        basket.add(onionBagel);
        basket.add(plainBagel);
        onionBagel.addFilling(egg);

        Assertions.assertFalse(basket.isFull());
    }

    // remove item - success
    @Test
    void canRemoveItemThatIsInBasket() {
        basket.add(onionBagel);
        basket.remove(onionBagel);

        Assertions.assertTrue(basket.getContents().isEmpty());
    }

    // remove item that doesn't exist in basket - failure
    @Test
    void cannotRemoveItemThatIsntInBasket() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> basket.remove(onionBagel));
        
    }

    // get total cost of basket with two bagels, one with 2 fillings
    @Test
    void getTotalCostOfBasket_twoBagelsTwoFillings_1p12() {
        basket.add(onionBagel);
        basket.add(plainBagel);
        onionBagel.addFilling(egg);
        onionBagel.addFilling(bacon);

        double expected = 0.49 + 0.39 + 0.12 + 0.12;
        double actual = basket.getTotalPrice(); 

        Assertions.assertEquals(expected, actual);
    }
}
