package com.gildedrose.models;

public class ConjuredItem extends StandardProduct {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int decreasingValueOverZeroDaysToSell() {
        return 2;
    }

}
