package com.gildedrose;

import com.gildedrose.configurations.ApplicationConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suites for  Sulfuras items.
 */
class GildedRoseSulfurasItemTest {

    @Test
    public void sulfurasHasQualityEighty() {
        GildedRose app =
            GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.SULFURAS, 1, 80);

        assertEquals(80, GildedRoseTestHelper.getFirstItemQuality(app));
    }

    @Test
    public void sulfurasItemDoesNotAlterValues() {
        GildedRose app = GildedRoseTestHelper.createOneItemGildedRoseApp(ApplicationConstants.SULFURAS, 1, 80);
        app.updateQuality();
        assertEquals(80, GildedRoseTestHelper.getFirstItemQuality(app));
        assertEquals(1, GildedRoseTestHelper.getFirstItemSellIn(app));
    }

}
