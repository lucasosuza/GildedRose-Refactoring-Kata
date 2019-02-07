package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    @Test
    public void agedBrieItemsShouldIncreaseQualityOvertime() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Aged Brie", 1, 0));
        assertEquals("The quality of Aged Brie should had be increased by 1", 1, app.items[0].quality);
    }

    @Test
    public void agedBrieItemsShouldIncreaseQualityOvertimeAtFixedHateAfterSellIn() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Aged Brie", 0, 0));
        assertEquals("The quality of Aged Brie should had be increased by 1 even after expired", 1, app.items[0].quality);
    }

    @Test
    public void qualityOfAItemShouldNotBeMoreThan50() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Aged Brie", 0, 50));
        assertEquals("The maximum value of quality property cannot be grater than 50", 50, app.items[0].quality);
    }
}
