package com.fpinkotlin.makingjavafunctional.exercise03_07

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionUtilitiesTest {

	@Test
	fun testFoldRight() {
		val list = list(1, 2, 3, 4, 5)
		val identity = "0"
		val f: (Int) -> (String) -> (String) = { x -> { y -> "($x + $y)" } }
		assertEquals("(1 + (2 + (3 + (4 + (5 + 0)))))", foldRight(list, identity, f))
	}
}
