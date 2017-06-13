package com.fpinkotlin.lists.exercise05_03

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testToString() {
		assertEquals("[NIL]", list<String>().toString())
		assertEquals("[1, 2, 3, NIL]", list(1, 2, 3).toString())
	}
}
