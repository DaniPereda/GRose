package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (notAgedBrie(i) && notBackStage(i)) {
                if (items[i].quality > 0) {
                    if (notSulfuras(i)) {
                        decreaseQuality(i)
                        decreaseQualityConjured(i)
                    }
                }
            } else {
                if (notMaxQuality(i)) {
                    increaseQuality(i)

                    manageBackStageExtraQuality(i)
                }
            }

            if (notSulfuras(i)) {
                decreaseSellIn(i)
            }

            if (sellDateExceeded(i)) {
                if (notAgedBrie(i)) {
                    if (notBackStage(i)) {
                        if (items[i].quality > 0) {
                            if (notSulfuras(i)) {
                                decreaseQuality(i)
                                decreaseQualityConjured(i)
                            }
                        }
                    } else {
                        setQualityToZero(i)
                    }
                } else {
                    if (notMaxQuality(i)) {
                        increaseQuality(i)
                    }
                }
            }
        }
    }

    private fun decreaseQualityConjured(i: Int) {
        if (conjuredItem(i))
            decreaseQuality(i)
    }

    private fun sellDateExceeded(i: Int) = items[i].sellIn < 0

    private fun decreaseSellIn(i: Int) {
        items[i].sellIn = items[i].sellIn - 1
    }

    private fun decreaseQuality(i: Int) {
        items[i].quality = items[i].quality - 1
    }

    private fun manageBackStageExtraQuality(i: Int) {
        if (backStage(i)) {
            if (items[i].sellIn < 11) {
                if (notMaxQuality(i)) {
                    increaseQuality(i)
                }
            }

            if (items[i].sellIn < 6) {
                if (notMaxQuality(i)) {
                    increaseQuality(i)
                }
            }
        }
    }

    private fun setQualityToZero(i: Int) {
        items[i].quality = items[i].quality - items[i].quality
    }

    private fun increaseQuality(i: Int) {
        items[i].quality = items[i].quality + 1
    }

    private fun notMaxQuality(i: Int) = items[i].quality < 50

    private fun backStage(i: Int) = items[i].name == "Backstage passes to a TAFKAL80ETC concert"

    private fun notSulfuras(i: Int) = items[i].name != "Sulfuras, Hand of Ragnaros"

    private fun notBackStage(i: Int) = items[i].name != "Backstage passes to a TAFKAL80ETC concert"

    private fun notAgedBrie(i: Int) = items[i].name != "Aged Brie"

    private fun conjuredItem(i: Int) = items[i].name == "Conjured Mana Cake"

}

