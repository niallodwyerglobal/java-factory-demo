package com.example.basket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineItemTest {

    @Test
    void theLineTotalIsTheUnitPriceTimesTheQuantity() {
        final LineItem item = new LineItem("TEA-01", Money.of("2.50"), 3);

        assertThat(item.lineTotal()).isEqualTo(Money.of("7.50"));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void refusesAQuantityBelowOne(final int quantity) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LineItem("TEA-01", Money.of("2.50"), quantity));
    }

    @Test
    void refusesABlankSku() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LineItem(" ", Money.of("2.50"), 1));
    }
}
