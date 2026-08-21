package com.booleanuk.core.model;

import java.util.ArrayList;
import java.util.List;

import com.booleanuk.core.inventory.Inventory;

public class Basket {
    int capacity;
    List<Item> contents;
    Inventory bobsInventory;

    public Basket(int capacity) {
        this.capacity = capacity;
        contents = new ArrayList<>();
        bobsInventory = new Inventory();
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
            throw new IllegalArgumentException("Cannot remove an item that is not in the basket.");
    }

    public double getTotalCost() {
        double totalCost = 0;

        for (Item i : contents) 
            totalCost += i.getPrice();

        return totalCost;
    }

}
