package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private static GildedRose buildGildedRoseWith(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }

    @Test
    public void shouldPreserveTheNameProperty() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = buildGildedRoseWith(item);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldDecreaseQualityByOneOfOrdinaryItems() {
        GildedRose app = buildGildedRoseWith(new Item("foo", 0, 1));
        app.updateQuality();
        assertEquals("The quality property doesn´t decreased as expected", 0, app.items[0].quality);
    }

    @Test
    public void shouldNotDecreaseByNegativeQuality() {
        GildedRose app = buildGildedRoseWith(new Item("foo", 0, 0));
        app.updateQuality();
        assertEquals("The quality property cannot be negative", 0, app.items[0].quality);
    }

    @Test
    public void agedBrieItemsShouldIncreaseQualityOvertime() {
        GildedRose app = buildGildedRoseWith(new Item("Aged Brie", 1, 0));
        app.updateQuality();
        assertEquals("The quality of Aged Brie should had be increased by 1", 1, app.items[0].quality);
    }

    @Test
    public void agedBrieItemsShouldIncreaseQualityOvertimeAtFixedHateAfterSellIn() {
        GildedRose app = buildGildedRoseWith(new Item("Aged Brie", 0, 0));
        app.updateQuality();
        assertEquals("The quality of Aged Brie should had be increased by 1 even after expired", 1, app.items[0].quality);
    }

    @Test
    public void qualityOfAItemShouldNotBeMoreThan50() {
        GildedRose app = buildGildedRoseWith(new Item("Aged Brie", 0, 50));
        app.updateQuality();
        assertEquals("The maximum value of quality property cannot be grater than 50", 50, app.items[0].quality);
    }

    // TODO add initial verification of properties?
    @Test
    public void sulfurasItemShouldFixedQualityOf80() {
        GildedRose app = buildGildedRoseWith(new Item("Sulfuras, Hand of Ragnaros", 1, 80));
        app.updateQuality();
        assertEquals("The quality of Sulfuras has to be fixed at 80", 80, app.items[0].quality);
    }

    @Test
    public void sulfurasItemShouldFixedQualityOf80EvenAfterSellin() {
        GildedRose app = buildGildedRoseWith(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        app.updateQuality();
        assertEquals("The quality of Sulfuras has to be fixed at 80 even after expired", 80, app.items[0].quality);
    }

    @Test
    public void sulfurasItemShouldFixedQualityOf80AndDontBeUpdateOverAnyTime() {
        int sellIn = (int) (Math.random() * 100);
        GildedRose app = buildGildedRoseWith(new Item("Sulfuras, Hand of Ragnaros", sellIn, 80));

        for (int i = 0; i < sellIn + 1; i++) {
            app.updateQuality();
        }

        assertEquals("The quality of Sulfuras has to be fixed at 80 for any time", 80, app.items[0].quality);
    }

    @Test
    public void backstagePassesShouldIncreseQualityOverTime() {
        GildedRose app = buildGildedRoseWith(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10));
        app.updateQuality();
        assertEquals("The quality of Backstage passes has to increase", 11, app.items[0].quality);
    }

    @Test
    public void backstagePassesShouldIncreseQualityBy2At10DaysOrLess() {
        GildedRose app = buildGildedRoseWith(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10));
        app.updateQuality();
        assertEquals("The quality of Backstage passes has to increase by 2 when there are 10 days or less", 12, app.items[0].quality);
    }

    @Test
    public void backstagePassesShouldIncreseQualityBy3At5DaysOrLess() {
        GildedRose app = buildGildedRoseWith(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10));
        app.updateQuality();
        assertEquals("The quality of Backstage passes has to increase by 3 when there are 5 days or less", 13, app.items[0].quality);
    }

    @Test
    public void backstagePassesQualityShouldDropToZeroAfterConcert() {
        GildedRose app = buildGildedRoseWith(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10));
        app.updateQuality();
        assertEquals("The quality of Backstage passes should drop to zero after the concert", 0, app.items[0].quality);

    }


}
