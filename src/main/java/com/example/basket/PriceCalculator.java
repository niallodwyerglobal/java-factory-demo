package com.example.basket;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Prices a basket: subtotal, VAT at the standard UK rate, and total.
 */
public final class PriceCalculator {

    static final BigDecimal VAT_RATE = new BigDecimal("0.20");

    public Quote quote(final Basket basket) {
        final Money subtotal = basket.items().stream()
                .map(LineItem::lineTotal)
                .reduce(Money.ZERO, Money::plus);
        final Money vat = subtotal.times(VAT_RATE, RoundingMode.HALF_DOWN);
        return new Quote(subtotal, vat, subtotal.plus(vat));
    }
}
