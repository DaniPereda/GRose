package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("fixme", app.items[0].name)

    }

    @Test
    fun `common sellIn greater 0 and quality greater 0`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Elixir of the Mongoose", 5, 7))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN


        assertEquals("Elixir of the Mongoose", sut.items[0].name)
        assertEquals(4, sut.items[0].sellIn)
        assertEquals(6, sut.items[0].quality)
    }

    @Test
    fun `common sellIn equal 0 and quality equal 1`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Elixir of the Mongoose", 0, 1))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(-1, sut.items[0].sellIn)
        assertEquals(-0, sut.items[0].quality)
    }

    @Test
    fun `common sellIn equal 0 and quality equal 5`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Elixir of the Mongoose", 0, 5))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(3, sut.items[0].quality)
    }
    @Test
    fun `aged brie sellIn greater than 0 and quality equal 0`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Aged Brie", 5, 4))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(4, sut.items[0].sellIn)
        assertEquals(5, sut.items[0].quality)
    }

    @Test
    fun `aged brie max quality 50`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Aged Brie", 1, 49))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(0, sut.items[0].sellIn)
        assertEquals(50, sut.items[0].quality)
    }

    @Test
    fun `aged brie if sellIn less than 0 then quality equals to 0`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Aged Brie", 0, 49))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(-1, sut.items[0].sellIn)
        assertEquals(0, sut.items[0].quality)
    }

    @Test
    fun `backstage pass quality increase by 1 when sellIn greater than 10`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 11, 5))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(10, sut.items[0].sellIn)
        assertEquals(6, sut.items[0].quality)
    }

    @Test
    fun `backstage pass quality increase by 2 when sellIn between 6 and 10`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 6, 8))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(10, sut.items[0].quality)
    }

    @Test
    fun `backstage pass quality increase by 3 when sellIn lower than 6`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 8))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(11, sut.items[0].quality)
    }

    @Test
    fun `sulfuras quality ans sellIn doesn't change`(){
        // GIVEN
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val sut = GildedRose(items)
        // WHEN
        sut.updateQuality()
        // THEN
        assertEquals(80, sut.items[0].quality)
        assertEquals(0, sut.items[0].sellIn)
    }




}


