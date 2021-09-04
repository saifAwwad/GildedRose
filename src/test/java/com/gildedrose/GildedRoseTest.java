package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suites for all basic items (no special behavior)
 */
class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void basicItemDecreasesSellInDayEachTime() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp("standard item", 0, 0);
        app.updateQuality();
        assertEquals(-1, GildedRoseTestHelper.getFirstItemSellIn(app));
    }

    @Test
    public void basicItemDecreasesQualityByOneIfSellInDayIsAboveZero() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp("foo", 2, 1);
        app.updateQuality();
        assertEquals(0, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void basicItemDecreasesQualityByTwoOnceSellInDayIsZeroOrLess() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp("foo",0, 5);
        app.updateQuality();
        assertEquals(3, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void basicItemCannotHaveQualityLessThanZero() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp("foo", 0, 0);
        app.updateQuality();
        assertEquals(0,  GildedRoseTestHelper.getFirstItemQuality(app));
    }


}
