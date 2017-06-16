package com.fpinkotlin.lists.exercise05_21

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testFlatMap() {
		assertEquals("[1, 1, 2, 2, 3, 3, NIL]", list(1, 2, 3).flatMap { i -> list(i, i) }.toString())
	}
}
