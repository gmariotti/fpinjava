package com.fpinkotlin.lists.exercise05_04

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testDrop() {
		assertEquals("[NIL]", list<Any>().drop(3).toString())
		assertEquals("[NIL]", list(1, 2, 3).drop(3).toString())
		assertEquals("[NIL]", list(1, 2, 3).drop(4).toString())
		assertEquals("[3, NIL]", list(1, 2, 3).drop(2).toString())
	}
}
