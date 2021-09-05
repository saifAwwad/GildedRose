package com.gildedrose.models;

public class StandardProduct implements BasicItem {

    private final Item item;

    public StandardProduct(Item item) {
        this.item = item;
    }

    public void updateState() {
        decreaseSellInValueByOne();
        if (sellInValueIsOverZero()) {
            decreaseQualityBy(decreasingValueOverZeroDaysToSell());
        } else {
            decreaseQualityBy(decreasingValueForZeroOrLessDaysToSell());
        }
    }

    public int decreasingValueOverZeroDaysToSell() {
        return 1;
    }

    private void decreaseSellInValueByOne() {
        item.sellIn -= 1;
    }

    private boolean sellInValueIsOverZero() {
        return item.sellIn > 0;
    }

    private void decreaseQualityBy(int qualityValue) {
        item.quality -= qualityValue;
    }

    private int decreasingValueForZeroOrLessDaysToSell() {
        return decreasingValueOverZeroDaysToSell() * 2;
    }
}
