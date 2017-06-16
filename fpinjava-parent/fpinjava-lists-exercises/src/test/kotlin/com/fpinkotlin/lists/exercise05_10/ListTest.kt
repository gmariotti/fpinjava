package com.fpinkotlin.lists.exercise05_10

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testFoldLeft() {
		assertEquals(0, list<Int>().foldLeft(0) { x -> { y -> x + y } })
		assertEquals(6, list(1, 2, 3).foldLeft(0) { x -> { y -> x + y } })
		assertEquals(1.0, list<Double>().foldLeft(1.0) { x -> { y -> x * y } }, 0.0)
		assertEquals(24.0, list(1.0, 2.0, 3.0, 4.0).foldLeft(1.0) { x -> { y -> x * y } }, 0.0)
	}
}
