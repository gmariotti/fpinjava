package com.fpinkotlin.makingjavafunctional.exercise03_12

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionUtilitiesTest {

	@Test
	fun testUnfold() {
		assertEquals("[1, 2, 4, 8]", unfold(1, { x -> x * 2 }) { x -> x < 10 }.toString())
		assertEquals("[x, xx, xxx, xxxx]", unfold("x", { x -> x + "x" }) { x -> x.length < 5 }.toString())
	}
}
