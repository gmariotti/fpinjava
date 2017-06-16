package com.fpinkotlin.lists.exercise05_16

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testFlatten() {
		assertEquals("[4, 5, 6, NIL]", flatten(list(list<Int>(), list(4, 5, 6))).toString())
		assertEquals("[1, 2, 3, NIL]", flatten(list(list(1, 2, 3), list<Int>())).toString())
		assertEquals("[1, 2, 3, 4, 5, 6, NIL]", flatten(list(list(1, 2, 3), list(4, 5, 6))).toString())
	}
}
