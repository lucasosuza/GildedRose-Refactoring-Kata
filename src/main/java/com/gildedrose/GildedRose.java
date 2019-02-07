package com.gildedrose;

class GildedRose {

    public static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!isAgedBrie(items[i])
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                decreaseQualityByOne(i);

            } else {
                if (items[i].quality < MAXIMUM_QUALITY) {
                    increaseQualityByOne(i);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            increaseQualityByOne(i);
                        }

                        if (items[i].sellIn < 6) {
                            increaseQualityByOne(i);

                        }
                    }
                }
            }

            descreaseSellIn(i);

            if (items[i].sellIn < 0) {

                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (canDecreaseQuality(items[i])) {
                            if (isNotSulfuras(items[i])) {
                                decreaseQualityByOne(i);
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality; //?
                    }
                } else {
                    increaseQualityByOne(i);

                }
            }
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void descreaseSellIn(int itemIndex) {
        if (isNotSulfuras(items[itemIndex])) {
            items[itemIndex].sellIn = items[itemIndex].sellIn - 1;
        }

    }

    private boolean isNotSulfuras(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean canIncreaseQuality(Item item) {
        return item.quality < MAXIMUM_QUALITY && isNotSulfuras(item);
    }

    private boolean canDecreaseQuality(Item item) {
        return item.quality > MINIMUM_QUALITY && isNotSulfuras(item);
    }

    private void increaseQualityByOne(int itemIndex) {
        if (canIncreaseQuality(items[itemIndex])) {
            items[itemIndex].quality = items[itemIndex].quality + 1;
        }
    }

    private void decreaseQualityByOne(int itemIndex) {
        if (canDecreaseQuality(items[itemIndex])) {
            items[itemIndex].quality = items[itemIndex].quality - 1;
        }
    }
}