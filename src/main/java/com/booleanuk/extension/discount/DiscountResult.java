package com.booleanuk.extension.discount;

import java.util.List;

import com.booleanuk.core.model.Item;

public record DiscountResult(
    double price,
    List<Item> remainingItems
) {}
