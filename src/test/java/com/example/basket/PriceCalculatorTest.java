package com.example.basket;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

    private final PriceCalculator calculator = new PriceCalculator();

    @Test
    void anEmptyBasketCostsNothing() {
        final Quote quote = calculator.quote(Basket.empty());

        assertThat(quote).isEqualTo(new Quote(Money.ZERO, Money.ZERO, Money.ZERO));
    }

    @Test
    void addsVatAtTwentyPercentToTheSubtotal() {
        final Basket basket = Basket.empty()
                .add(new LineItem("TEA-01", Money.of("2.50"), 2))
                .add(new LineItem("MUG-01", Money.of("5.00"), 1));

        final Quote quote = calculator.quote(basket);

        assertThat(quote.subtotal()).isEqualTo(Money.of("10.00"));
        assertThat(quote.vat()).isEqualTo(Money.of("2.00"));
        assertThat(quote.total()).isEqualTo(Money.of("12.00"));
    }
}
