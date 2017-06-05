package com.fpinkotlin.makingjavafunctional.exercise03_06

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionUtilitiesTest {

	@Test
	fun testFoldLeft() {
		val list = list(1, 2, 3, 4, 5)
		val identity = "0"
		val f: (String) -> (Int) -> (String) = { x -> { y -> "($x + $y)" } }
		assertEquals("(((((0 + 1) + 2) + 3) + 4) + 5)", foldLeft(list, identity, f))
	}
}
