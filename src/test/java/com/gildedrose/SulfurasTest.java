package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    @Test
    public void sulfurasItemShouldFixedQualityOf80() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Sulfuras, Hand of Ragnaros", 1, 80));
        assertEquals("The quality of Sulfuras has to be fixed at 80", 80, app.items[0].quality);
    }

    @Test
    public void sulfurasItemShouldFixedQualityOf80EvenAfterSellin() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        assertEquals("The quality of Sulfuras has to be fixed at 80 even after expired", 80, app.items[0].quality);
    }

    @Test
    public void sulfurasItemShouldFixedQualityOf80AndDontBeUpdateOverAnyTime() {
        int sellIn = (int) (Math.random() * 100);
        GildedRose app = GildedRoseTest.buildGildedRoseWith(new Item("Sulfuras, Hand of Ragnaros", sellIn, 80));

        for (int i = 0; i < sellIn + 1; i++) {
            app.updateQuality();
        }

        assertEquals("The quality of Sulfuras has to be fixed at 80 for any time", 80, app.items[0].quality);
    }
}
