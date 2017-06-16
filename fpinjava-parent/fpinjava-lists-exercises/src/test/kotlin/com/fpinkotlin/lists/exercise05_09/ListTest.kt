package com.fpinkotlin.lists.exercise05_09

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testLength() {
		assertEquals(0, list<Any>().length())
		assertEquals(3, list(1, 2, 3).length())
	}
}
