package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    static GildedRose buildGildedRoseWith(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }

    static GildedRose buildGuildedRoseAndUpdateQuality(Item item) {
        GildedRose app = buildGildedRoseWith(item);
        app.updateQuality();
        return app;
    }

    @Test
    public void shouldPreserveTheNameProperty() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = buildGuildedRoseAndUpdateQuality(item);
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldDecreaseQualityByOneOfOrdinaryItems() {
        GildedRose app = buildGuildedRoseAndUpdateQuality(new Item("foo", 0, 1));
        assertEquals("The quality property doesn´t decreased as expected", 0, app.items[0].quality);
    }

    @Test
    public void shouldNotDecreaseByNegativeQuality() {
        GildedRose app = buildGuildedRoseAndUpdateQuality(new Item("foo", 0, 0));
        assertEquals("The quality property cannot be negative", 0, app.items[0].quality);
    }

}
