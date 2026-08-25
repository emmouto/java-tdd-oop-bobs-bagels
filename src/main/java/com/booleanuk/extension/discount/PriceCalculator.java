package com.booleanuk.extension.discount;

import java.util.List;
import java.util.Optional;

import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Basket;
import com.booleanuk.core.model.Coffee;

public class PriceCalculator {
    private final List<Discount> discounts = List.of(
        new MultiPrice(Bagel.class, 6, 2.49),
        new MultiPrice(Bagel.class, 12, 3.99),
        new ComboDeal(List.of(Coffee.class, Bagel.class), 1.25)
    );

    // calculate discounts
    public double calculate(Basket basket) {
        return bestPrice(basket);
    }

    private double bestPrice(Basket basket) {
        double bestPrice = basket.getTotalPrice(); // start with price without any discounts applied

        for (Discount discount : discounts) {
            Optional<DiscountResult> result = discount.apply(basket);
        
            if (result.isPresent()) { // result can also be isEmpty() if no discounts could be applied
                DiscountResult discountResult = result.get();

                Basket remainingBasket = new Basket(
                    basket.getCapacity(), 
                    basket.getStock(), 
                    discountResult.remainingItems()
                );

                double discountedPrice = discountResult.price() + bestPrice(remainingBasket);

                bestPrice = Math.min(bestPrice, discountedPrice);
            }
        }

        return bestPrice;
    }
}
