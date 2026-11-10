package com.example.basket;

/**
 * What a basket costs.
 *
 * @param subtotal the sum of the line totals, before VAT
 * @param vat the VAT on the subtotal
 * @param total what the customer pays
 */
public record Quote(Money subtotal, Money vat, Money total) {
}
