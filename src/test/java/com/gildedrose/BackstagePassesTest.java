package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassesTest {
    
    @Test
    public void backstagePassesShouldIncreseQualityOverTime() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10));
        assertEquals("The quality of Backstage passes has to increase", 11, app.items[0].quality);
    }

    @Test
    public void backstagePassesShouldIncreseQualityBy2At10DaysOrLess() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10));
        assertEquals("The quality of Backstage passes has to increase by 2 when there are 10 days or less", 12, app.items[0].quality);
    }

    @Test
    public void backstagePassesShouldIncreseQualityBy3At5DaysOrLess() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10));
        assertEquals("The quality of Backstage passes has to increase by 3 when there are 5 days or less", 13, app.items[0].quality);
    }

    @Test
    public void backstagePassesQualityShouldDropToZeroAfterConcert() {
        GildedRose app = GildedRoseTest.buildGuildedRoseAndUpdateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10));
        assertEquals("The quality of Backstage passes should drop to zero after the concert", 0, app.items[0].quality);

    }
}
