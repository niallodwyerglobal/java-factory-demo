package com.example.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An immutable shopping basket. Adding an item returns a new basket.
 */
public final class Basket {

    private final List<LineItem> items;

    private Basket(final List<LineItem> items) {
        this.items = List.copyOf(items);
    }

    public static Basket empty() {
        return new Basket(List.of());
    }

    public Basket add(final LineItem item) {
        Objects.requireNonNull(item, "item");
        final List<LineItem> next = new ArrayList<>(items);
        next.add(item);
        return new Basket(next);
    }

    public List<LineItem> items() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
