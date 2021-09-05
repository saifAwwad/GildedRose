package com.gildedrose;

import com.gildedrose.configurations.ApplicationConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suites for  Backstage items.
 */
class GildedRoseBackstagePassesItemTest {

    @Test
    public void backstagePassesItemDecreasesSellByDayDayNumberEachTime() {
        GildedRose app =
            GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.BACKSTAGE_PASSES, 0, 0);
        app.updateQuality();
        assertEquals(-1, GildedRoseTestHelper.getFirstItemSellIn(app));
    }

    @Test
    public void backstagePassesItemIncreasesQualityByOneIfSellByDayMoreThanEleven() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.BACKSTAGE_PASSES, 12, 1);
        app.updateQuality();
        assertEquals(2, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void backstagePassesItemIncreasesQualityByTwoIfSellByDayIsMoreThanSixAndLessThanTen() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.BACKSTAGE_PASSES, 10, 1);
        app.updateQuality();
        assertEquals(3, GildedRoseTestHelper.getFirstItemQuality(app));
    }
    @Test
    public void backstagePassesItemDecreasesQualityByThreeIfSellByDayIsMoreThanZeroAndLessThanFive() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.BACKSTAGE_PASSES, 5, 1);
        app.updateQuality();
        assertEquals(4, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void backstagePassesItemQualityDropsToZeroIfSellByDayIsZeroOrLess() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.BACKSTAGE_PASSES, 0,50);
        app.updateQuality();
        assertEquals(0, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void backstagePassesItemQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.BACKSTAGE_PASSES, 5, 50);
        app.updateQuality();
        assertEquals(50, GildedRoseTestHelper.getFirstItemQuality(app));
    }

}
