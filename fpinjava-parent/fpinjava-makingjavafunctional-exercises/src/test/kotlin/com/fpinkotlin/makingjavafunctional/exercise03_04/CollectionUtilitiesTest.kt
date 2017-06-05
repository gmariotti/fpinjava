package com.fpinkotlin.makingjavafunctional.exercise03_04

import org.junit.Test

import org.junit.Assert.assertEquals

class CollectionUtilitiesTest {

	@Test(expected = NoSuchElementException::class)
	fun testHeadEmpty() {
		val list = list<String>()
		head(list)
	}

	@Test
	fun testHead() {
		val list = list("1")
		assertEquals("1", head(list))
		val list2 = list("1", "2", "3", "4")
		assertEquals("1", head(list2))
	}

	@Test(expected = IllegalStateException::class)
	fun testTailEmpty() {
		val list = list<String>()
		tail(list)
	}

	@Test
	fun testTail() {
		val list0 = list("1", "2", "3", "4")
		val list = tail(list0)
		assertEquals(3, list.size.toLong())
		assertEquals("2", list[0])
		assertEquals("3", list[1])
		assertEquals("4", list[2])
	}
}
