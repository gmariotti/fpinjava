package com.fpinkotlin.makingjavafunctional.exercise03_10

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionUtilitiesTest {

	@Test
	fun testMapViaFoldLeft() {
		assertEquals("[1, 4, 9]", mapViaFoldLeft(list(1, 2, 3)) { x -> x * x }.toString())
	}

	@Test
	fun testMapViaFoldRight() {
		assertEquals("[1, 4, 9]", mapViaFoldRight(list(1, 2, 3)) { x -> x * x }.toString())
	}
}
