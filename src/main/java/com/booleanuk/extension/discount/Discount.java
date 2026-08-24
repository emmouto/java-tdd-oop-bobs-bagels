package com.booleanuk.extension.discount;

import com.booleanuk.core.model.Basket;

public interface Discount {
    public double calculateDiscount(Basket basket);
}
