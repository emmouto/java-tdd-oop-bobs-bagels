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
        fillings.remove(filling);
    }

    public double getTotalCost() {
        double totalCost = getPrice();

        for (Filling f : fillings)
            totalCost += f.getPrice();

        return totalCost;
    }

    @Override
    public Bagel createCopy() {
        return new Bagel(getSKU(), getPrice(), getVariant());
    }
}
