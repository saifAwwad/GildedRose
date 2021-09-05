package com.gildedrose;

import com.gildedrose.configurations.ApplicationConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suites for  Conjured items.
 */
class GildedRoseConjuredItemTest {

    @Test
    public void conjuredItemDecreasesSellByDayNumberEachTime() {
        GildedRose app =
            GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.CONJURED, 0, 0);
        app.updateQuality();
        assertEquals(-1, GildedRoseTestHelper.getFirstItemSellIn(app));
    }


    @Test
    public void conjuredItemDecreasesQualityByTwoIfSellByDayIsAboveZero() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.CONJURED, 2, 5);
        app.updateQuality();
        assertEquals(3, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void conjuredItemDecreasesQualityByFourOnceSellByDayIsZeroOrLess() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.CONJURED,0, 5);
        app.updateQuality();
        assertEquals(1, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void conjuredItemCannotHaveQualityBelowZero() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.CONJURED, 0, 0);
        app.updateQuality();
        assertEquals(0, GildedRoseTestHelper.getFirstItemQuality(app));
    }


}
