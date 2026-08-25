package com.booleanuk.extension.discount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.booleanuk.core.model.Basket;
import com.booleanuk.core.model.Item;

public class MultiPrice implements Discount {
    private final Class<? extends Item> itemType;
    private final int amount;
    private final double price;

    public MultiPrice(Class<? extends Item> itemType, int amount, double price) {
        this.itemType = itemType;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public Optional<DiscountResult> apply(Basket basket) {
        List<Item> basketContents = basket.getContents();

        // get all items of specific item type, e.g. all Bagels
        long matching = basketContents.stream()
            .filter(itemType::isInstance) 
            .limit(amount) // only need to get `amount` for applying this discount
            .count();

            // not enough matching items in basket to apply multiprice discount
            if (matching < amount) 
                return Optional.empty();

            return Optional.of(new DiscountResult(
                price, 
                removeMatchingItems(basketContents)));
    }

    List<Item> removeMatchingItems(List<Item> items) {
        List<Item> remaining = new ArrayList<>();
        int removed = 0;

        for (Item item : items) {
            if (itemType.isInstance(item) && removed < amount) {
                removed++;
            } else {
                remaining.add(item);
            }
        }

        return remaining;
    }
}
