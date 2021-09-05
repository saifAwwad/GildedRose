package com.gildedrose;

import com.gildedrose.configurations.ApplicationConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suites for  Brie items.
 */
class GildedRoseBrieItemTest {

    @Test
    public void brieItemDecreasesSellInDayEachTime() {
        GildedRose app =
            GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.AGED_BRIE, 0, 0);
        app.updateQuality();
        assertEquals(-1, GildedRoseTestHelper.getFirstItemSellIn(app));
    }

    @Test
    public void brieItemIncreasesInQualityEachTime() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.AGED_BRIE, 1, 1);
        app.updateQuality();
        assertEquals(2, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void brieItemQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.AGED_BRIE, 1, 49);
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, GildedRoseTestHelper.getFirstItemQuality(app));;
    }


}
