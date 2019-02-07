package com.gildedrose;

class GildedRose {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Aged Brie":
                    increaseQuality(i);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    processQualityOfBackstagePasses(i);
                    break;

                case "Conjured Mana Cake":
                    decreaseQuality(i, 2);

                    break;
                default:
                    decreaseQualityByOne(i);
                    break;
            }

            descreaseSellIn(i);
        }
    }

    private void processQualityOfBackstagePasses(int i) {
        increaseQuality(i);


        if (items[i].sellIn < 11) {
            increaseQuality(i);
        }

        if (items[i].sellIn < 6) {
            increaseQuality(i);

        }

        if (isExpired(items[i])) {
            items[i].quality = 0;
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn <= 0;
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

    private void decreaseQualityByOne(int itemIndex) {
        decreaseQuality(itemIndex, 1);
    }

    private void increaseQuality(int itemIndex) {
        if (canIncreaseQuality(items[itemIndex])) {
            items[itemIndex].quality = items[itemIndex].quality + 1;
        }
    }

    private void decreaseQuality(int itemIndex, int value) {
        if (canDecreaseQuality(items[itemIndex])) {
            items[itemIndex].quality = items[itemIndex].quality - value;
        }
    }
}