package com.example.basket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * An amount of money in pounds sterling, held to the penny.
 *
 * @param amount the amount, always at a scale of two decimal places
 */
public record Money(BigDecimal amount) implements Comparable<Money> {

    public static final Money ZERO = Money.of("0.00");

    public Money {
        Objects.requireNonNull(amount, "amount");
        if (amount.scale() > 2) {
            throw new IllegalArgumentException("Money is held to the penny: " + amount);
        }
        amount = amount.setScale(2, RoundingMode.UNNECESSARY);
    }

    public static Money of(final String amount) {
        return new Money(new BigDecimal(amount));
    }

    public Money plus(final Money other) {
        return new Money(amount.add(other.amount));
    }

    public Money times(final int quantity) {
        return new Money(amount.multiply(BigDecimal.valueOf(quantity)));
    }

    /**
     * Multiplies by a rate and rounds the result to the penny.
     */
    public Money times(final BigDecimal rate, final RoundingMode rounding) {
        return new Money(amount.multiply(rate).setScale(2, rounding));
    }

    @Override
    public int compareTo(final Money other) {
        return amount.compareTo(other.amount);
    }

    @Override
    public String toString() {
        return "£" + amount.toPlainString();
    }
}
