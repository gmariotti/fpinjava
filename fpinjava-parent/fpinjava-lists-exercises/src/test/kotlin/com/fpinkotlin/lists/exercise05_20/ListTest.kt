package com.fpinkotlin.lists.exercise05_20

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testFilter() {
		assertEquals("[2, 4, 6, NIL]", list(1, 2, 3, 4, 5, 6).filter { x -> x % 2 == 0 }.toString())
	}
}
