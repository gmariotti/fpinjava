package com.fpinkotlin.lists.exercise05_06

import org.junit.Assert.assertEquals
import org.junit.Test


class ListTest {

	@Test
	fun testReverse() {
		assertEquals("[NIL]", list<Any>().reverse().toString())
		assertEquals("[3, 2, 1, NIL]", list(1, 2, 3).reverse().toString())
	}

	@Test(expected = IllegalStateException::class)
	fun testInitEmpty() {
		assertEquals("[NIL]", list<Any>().init().toString())
	}

	@Test
	fun testInit() {
		assertEquals("[1, 2, NIL]", list(1, 2, 3).init().toString())
	}
}
