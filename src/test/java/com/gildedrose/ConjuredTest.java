package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredTest {

    @Test
    public void conjuredItemsShouldDecreaseQualityFaster() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Conjured Mana Cake", 2, 20));
        assertEquals("The quality of Conjured item should had been decreased by 2", 18, app.items[0].quality);
    }
}
