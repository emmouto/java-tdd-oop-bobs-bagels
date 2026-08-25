package com.booleanuk.core.model;

import java.util.ArrayList;
import java.util.List;

import com.booleanuk.core.inventory.Stock;

public class Basket {
    private int capacity;
    private Stock stock;
    private List<Item> contents;
    
    public Basket(int capacity, Stock stock) {
        this.capacity = capacity;
        this.stock = stock;
        contents = new ArrayList<>();
    }

    // for creating a Basket with items already in it (for the PriceCalculator)
    public Basket(int capacity, Stock stock, List<Item> contents) {
        this.capacity = capacity;
        this.stock = stock;
        this.contents = contents;
    }

    public void changeCapacity(int newCapacity, Role role) {
        if (role == Role.MANAGER) {
            this.capacity = newCapacity;
        } else {
            throw new IllegalArgumentException("Only managers can change the basket capacity.");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Item item) {
        if (!stock.hasProduct(item.getSKU()))
            throw new IllegalArgumentException("Item not in stock.");

        if (!isFull()) {
            contents.add(item);
        } else {
            throw new IllegalStateException("Basket is full!");
        }
    }    
    
    public void remove(Bagel bagel) {
        if (!contents.remove(bagel))
            throw new IllegalArgumentException(
                "Cannot remove an item that is not in the basket.");
    }

    public List<Item> getContents() {
        return contents;
    }

    public boolean isFull() {
        return contents.size() >= capacity;
    }

    public double getTotalPrice() {
        double totalCost = 0;

        for (Item i : contents) 
            totalCost += i.getTotalPrice();

        return totalCost;
    }

    public Stock getStock() {
        return this.stock;
    }
}
