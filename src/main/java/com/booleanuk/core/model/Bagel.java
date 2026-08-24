package com.booleanuk.core.model;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item {
    List<Filling> fillings;

    public Bagel(String SKU, double price, String variant) {
        super(SKU, price, "Bagel", variant);
        fillings = new ArrayList<>();
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
    }

    public void removeFilling(Filling filling) {
        if (!fillings.remove(filling))
            throw new IllegalArgumentException("There is no " + filling.getVariant() + " in this bagel.");
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = getBasePrice();

        for (Filling f : fillings)
            totalPrice += f.getBasePrice();

        return totalPrice;
    }

    @Override
    public Bagel createCopy() {
        return new Bagel(getSKU(), getBasePrice(), getVariant());
    }
}
