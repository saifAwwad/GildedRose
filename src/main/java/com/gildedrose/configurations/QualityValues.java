package com.gildedrose.configurations;

import com.gildedrose.models.CustomisedItemFactory;
import com.gildedrose.models.Item;

public final class QualityValues {

    public static int highestValuePossible(Item item) {
        if (item.name.equals(ApplicationConstants.SULFURAS)) {
            return 80;
        }
        return 50;
    }
}
