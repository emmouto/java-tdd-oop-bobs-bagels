package com.booleanuk.extension.discount;

import java.util.List;
import java.util.Optional;

import com.booleanuk.core.model.Basket;
import com.booleanuk.core.model.Item;

public class ComboDeal implements Discount {
    List<Class<? extends Item>> items; // could potentially be a map? if the need for smth like "2 bagels + 1 coffe for 2.00" arises
    double price;

    public ComboDeal(List<Class<? extends Item>> items, double price) {
        this.items = items;
        this.price = price;
    }

    public Optional<DiscountResult> apply(Basket basket) {
        // TODO

        return Optional.empty();
    }
}
