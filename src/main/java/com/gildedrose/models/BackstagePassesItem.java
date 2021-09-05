package com.gildedrose.models;

public class BackstagePassesItem implements BasicItem {

    private final Item item;

    public BackstagePassesItem(Item item) {
        this.item = item;
    }

    public void updateState() {
        decreaseSellInValueByOne();
        if (sellInValueIsOver(10)) {
            increaseQualityBy(1);
        } else if (sellInValueIsOver(5)) {
            increaseQualityBy(2);
        } else if (sellInValueIsOver(0)) {
            increaseQualityBy(3);
        } else {
            dropQualityToZero();
        }
    }

    private void decreaseSellInValueByOne() {
        item.sellIn -= 1;
    }

    private boolean sellInValueIsOver(int dayNumber) {
        return item.sellIn > dayNumber;
    }

    private void increaseQualityBy(int qualityValue) {
        item.quality += qualityValue;
    }

    private void dropQualityToZero() {
        item.quality = 0;
    }
}
