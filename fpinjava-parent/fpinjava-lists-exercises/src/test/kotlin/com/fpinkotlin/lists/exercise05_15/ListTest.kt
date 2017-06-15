package com.fpinkotlin.lists.exercise05_15

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testConcat() {
		assertEquals("[4, 5, 6, NIL]", concat(list<Int>(), list(4, 5, 6)).toString())
		assertEquals("[1, 2, 3, NIL]", concat(list(1, 2, 3), list<Int>()).toString())
		assertEquals("[1, 2, 3, 4, 5, 6, NIL]", concat(list(1, 2, 3), list(4, 5, 6)).toString())
	}
}
