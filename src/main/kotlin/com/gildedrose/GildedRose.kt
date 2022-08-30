package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            when {
                isSulfuras(item) -> break
                isAgedBrie(item) -> manageAgedBrie(item)
                isBackStage(item) -> manageBackStage(item)
                isConjuredItem(item) -> manageConjuredItem(item)
                else -> manageCommonItem(item)
            }
        }
    }


    private fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun decreaseQuality(item: Item) {
        item.quality = item.quality - 1
    }

    private fun manageBackStage(item: Item) {
        increaseQuality(item)

        if (sellInExceeded(item))
            setQualityToZero(item)
        else {
            if (item.sellIn < 11)
                increaseQuality(item)
            if (item.sellIn < 6)
                increaseQuality(item)
            controlMaxQuality(item)
        }
        decreaseSellIn(item)
    }

    private fun controlMaxQuality(item: Item) {
        if (item.quality > 50) item.quality = 50
    }

    private fun manageCommonItem(item: Item) {
        decreaseQuality(item)
        manageDateSellInExceeded(item)
        controlMinimunQuality(item)
        decreaseSellIn(item)
    }

    private fun controlMinimunQuality(item: Item) {
        if (item.quality < 0) item.quality = 0
    }

    private fun manageDateSellInExceeded(item: Item) {
        if (sellInExceeded(item)) {
            decreaseQuality(item)
        }
    }

    private fun sellInExceeded(item: Item) = item.sellIn <= 0

    private fun manageAgedBrie(item: Item) {
        if (item.quality < 50) {
            item.quality += 1
        }
        decreaseSellIn(item)
    }

    private fun setQualityToZero(item: Item) {
        item.quality = 0
    }

    private fun increaseQuality(item: Item) {
        item.quality = item.quality + 1
    }
    private fun isSulfuras(item: Item) = item.name == "Sulfuras, Hand of Ragnaros"

    private fun isBackStage(item: Item) = item.name == "Backstage passes to a TAFKAL80ETC concert"

    private fun isAgedBrie(item: Item) = item.name == "Aged Brie"

    private fun isConjuredItem(item: Item) = item.name == "Conjured Mana Cake"

    private fun manageConjuredItem(item: Item) {
        decreaseQuality(item)
        decreaseQuality(item)
        manageDateSellInExceeded(item)
        manageDateSellInExceeded(item)
        controlMinimunQuality(item)

        decreaseSellIn(item)

    }

}

