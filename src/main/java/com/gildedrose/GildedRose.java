package com.gildedrose;

import com.gildedrose.configurations.ApplicationConstants;
import com.gildedrose.configurations.QualityValues;
import com.gildedrose.models.BasicItem;
import com.gildedrose.models.CustomisedItemFactory;
import com.gildedrose.models.Item;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            customisedItem(item).updateState();
            if (hasReachedLowestQualityValue(item)) {
                item.quality = ApplicationConstants.LOWEST_QUALITY_VALUE;
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = QualityValues.highestValuePossible(item);
            }
        }
    }

    private BasicItem customisedItem(Item item) {
        return new
            CustomisedItemFactory(item).customiseItem(item);
    }

    private boolean hasReachedLowestQualityValue(Item item) {
        return item.quality < ApplicationConstants.LOWEST_QUALITY_VALUE;
    }

    private boolean hasReachedHighestQualityValue(Item item) {
        return item.quality > QualityValues.highestValuePossible(item);
    }
}
