package com.booleanuk.core.model;

import java.util.ArrayList;
import java.util.List;

import com.booleanuk.core.inventory.Inventory;

public class Basket {
    int capacity;
    Inventory inventory;
    List<Item> contents;
    
    public Basket(int capacity, Inventory inventory) {
        this.capacity = capacity;
        this.inventory = inventory;
        contents = new ArrayList<>();
    }

    public void changeCapacity(int newCapacity, Role role) {
        if (role == Role.MANAGER) {
            this.capacity = newCapacity;
        } else {
            throw new IllegalArgumentException("Only managers can change the basket capacity.");
        }
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void add(Item item) {
        if (!inventory.hasItem(item.getSKU()))
            throw new IllegalArgumentException("Item not in stock.");

        if (!isFull()) {
            contents.add(item);
        } else {
            throw new IllegalStateException("Basket is full!");
        }
    }

    public List<Item> getContents() {
        return contents;
    }

    public boolean isFull() {
        return contents.size() >= capacity;
    }

    public void remove(Bagel bagel) {
        if (!contents.remove(bagel))
            throw new IllegalArgumentException(
                "Cannot remove an item that is not in the basket.");
    }

    public double getTotalPrice() {
        double totalCost = 0;

        for (Item i : contents) 
            totalCost += i.getTotalPrice();

        return totalCost;
    }
}
