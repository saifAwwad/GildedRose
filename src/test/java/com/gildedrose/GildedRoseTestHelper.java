package com.gildedrose;

/**
 * Class contains all tests shared utils.
 */
public class GildedRoseTestHelper {
    /**
     * Create new GildeRose object.
     * @param itemName
     * @param itemSellIn
     * @param itemQuality
     * @return GildeRose app.
     */
    public static GildedRose createOneItemGildedRoseApp(String itemName, int itemSellIn,
                                                        int itemQuality) {
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }

    /**
     * Read GildedRose app first item sell-in value.
     * @param app
     * @return app.items[0].sellin
     */
    public static int getFirstItemSellIn(GildedRose app) {
        return app.items[0].sellIn;
    }

    /**
     * Read GildedRose app first item quality value.
     * @param app
     * @return app.items[0].quality
     */
    public static int getFirstItemQuality(GildedRose app) {
        return app.items[0].quality;
    }
}
