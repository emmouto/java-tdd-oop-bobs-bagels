package com.booleanuk.core;

import java.util.List;

public class Bagel extends Item {
    private String SKU;
    private double price;
    private String name;
    private String variant;

    public Bagel(String SKU, double price, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.name = "Bagel";
        this.variant = variant;
    }

    public Bagel(String string) {
        //TODO Auto-generated constructor stub
    }

    public List<Filling> getFillings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFillings'");
    }

    public void addFilling(Filling eggFilling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFilling'");
    }

    public void removeFilling(Filling baconFilling) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFilling'");
    }

    public double getTotalCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalCost'");
    }

    public String getFullName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFullName'");
    }

    public Object getSKU() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSKU'");
    }

    public Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

}
