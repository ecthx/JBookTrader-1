package com.jbooktrader.indicator.price;

import com.jbooktrader.platform.indicator.*;

public class PriceEMA extends Indicator {

    private final double alpha;

    private double price;

    public PriceEMA(int period) {
        this.alpha = 2.0 / (period + 1.0);
        reset();
    }

    @Override
    public void reset() {
        value = 0.0;
    }

    @Override
    public void calculate() {
        price = marketBook.getSnapshot().getPrice();
        value += alpha * (price - value);
    }

}