package com.gildedrose.models;

import com.gildedrose.configurations.ApplicationConstants;

import java.util.HashMap;
import java.util.Map;

public class CustomisedItemFactory {
    private final static Map<String, BasicItem> ITEM_TYPES_LIST =
        new HashMap<>();
    public CustomisedItemFactory(Item item) {
        ITEM_TYPES_LIST.put(ApplicationConstants.SULFURAS, new Sulfuras());
        ITEM_TYPES_LIST.put(ApplicationConstants.AGED_BRIE, new AgedBrie(item));
        ITEM_TYPES_LIST.put(ApplicationConstants.BACKSTAGE_PASSES,
            new BackstagePassesItem(item));
        ITEM_TYPES_LIST.put(ApplicationConstants.CONJURED,
            new ConjuredItem(item));
    }

    public BasicItem customiseItem(Item item) {
        if (isStandardItem(item)) {
            return new StandardProduct(item);
        }
        return ITEM_TYPES_LIST.get(item.name);
    }

    private boolean isStandardItem(Item item) {
        return !ITEM_TYPES_LIST.keySet().contains(item.name);
    }
}
