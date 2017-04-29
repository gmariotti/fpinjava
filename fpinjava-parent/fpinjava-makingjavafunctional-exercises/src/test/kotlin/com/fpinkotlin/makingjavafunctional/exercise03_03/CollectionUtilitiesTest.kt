package com.fpinkotlin.makingjavafunctional.exercise03_03

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionUtilitiesTest {

	@Test
	fun testList() {
		val list = list<Int>()
		assertEquals(0, list.size.toLong())
	}

	@Test
	fun testListT() {
		val s = "s"
		val list = list(s)
		assertEquals(1, list.size.toLong())
		assertEquals(s, list[0])
	}

	@Test
	fun testListListOfT() {
		val list0 = list("1", "2", "3", "4")
		val list = list(list0)
		assertEquals(4, list.size.toLong())
		assertEquals("1", list[0])
		assertEquals("2", list[1])
		assertEquals("3", list[2])
		assertEquals("4", list[3])
	}

	@Test
	fun testListTArray() {
		val list = list("1", "2", "3", "4")
		assertEquals(4, list.size.toLong())
		assertEquals("1", list[0])
		assertEquals("2", list[1])
		assertEquals("3", list[2])
		assertEquals("4", list[3])
	}
}
