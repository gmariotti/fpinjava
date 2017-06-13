package com.fpinkotlin.lists.exercise05_05

import org.junit.Assert.assertEquals
import org.junit.Test


class ListTest {

	@Test
	fun testDropWhile() {
		// For the empty list, we have to annotate the method list() to help Kotlin type inference
		assertEquals("[NIL]", list<Int>().dropWhile { x -> x < 3 }.toString())
		assertEquals("[1, 2, 3, NIL]", list(1, 2, 3).dropWhile { x -> x > 3 }.toString())
		assertEquals("[3, NIL]", list(1, 2, 3).dropWhile { x -> x < 3 }.toString())
		assertEquals("[NIL]", list(1, 2, 3).dropWhile { x -> x < 5 }.toString())
	}
}
