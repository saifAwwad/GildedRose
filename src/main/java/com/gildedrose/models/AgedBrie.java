package com.gildedrose.models;

public class AgedBrie implements BasicItem {

    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    public void updateState() {
        decreaseSellInValueByOne();
        increaseQualityByOne();
    }

    private void decreaseSellInValueByOne() {
        item.sellIn -= 1;
    }

    private void increaseQualityByOne() {
        item.quality += 1;
    }
}
