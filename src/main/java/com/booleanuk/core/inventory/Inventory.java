package com.booleanuk.core.inventory;

import java.util.HashMap;
import java.util.Map;

import com.booleanuk.core.model.Bagel;
import com.booleanuk.core.model.Coffee;
import com.booleanuk.core.model.Filling;
import com.booleanuk.core.model.Product;

public class Inventory implements Stock {
    private Map<String, Product> stockedProducts;

    public Inventory() {
        stockedProducts = new HashMap<>();
    }

    public boolean hasProduct(String SKU) {
        return stockedProducts.containsKey(SKU);
    }

    public Product getStockProduct(String SKU) {
        return stockedProducts.get(SKU);
    }

    public void addProductToInventory(Product Product) {
        stockedProducts.put(Product.getSKU(), Product);
    }

    /*public Product createProduct(String SKU) {
        Product Product = stockedProducts.get(SKU);

        if (Product == null)
            throw new IllegalArgumentException("Bob's Bagels does not stock that Product.");

        return Product.createCopy();
    }

    public Filling createFilling(String SKU) {
        Product Product = stockedProducts.get(SKU);

        if (Product == null)
            throw new IllegalArgumentException("Bob's Bagels does not stock that Product.");

        if (!(Product instanceof Filling))
            throw new IllegalArgumentException("Product is not a filling.");

        return (Filling) Product.createCopy();
    }*/
}
