package com.booleanuk.extension.discount;

import java.util.Optional;

import com.booleanuk.core.model.Basket;

public interface Discount {
    public Optional<DiscountResult> apply(Basket basket);
}
