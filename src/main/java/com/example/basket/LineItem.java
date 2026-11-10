package com.example.basket;

import java.util.Objects;

/**
 * One product in a basket, at a unit price, some number of times.
 *
 * @param sku the product's stock-keeping unit
 * @param unitPrice the price of one, before VAT
 * @param quantity how many, at least one
 */
public record LineItem(String sku, Money unitPrice, int quantity) {

    public LineItem {
        Objects.requireNonNull(sku, "sku");
        Objects.requireNonNull(unitPrice, "unitPrice");
        if (sku.isBlank()) {
            throw new IllegalArgumentException("sku must not be blank");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity must be at least 1: " + quantity);
        }
    }

    public Money lineTotal() {
        return unitPrice.times(quantity);
    }
}
