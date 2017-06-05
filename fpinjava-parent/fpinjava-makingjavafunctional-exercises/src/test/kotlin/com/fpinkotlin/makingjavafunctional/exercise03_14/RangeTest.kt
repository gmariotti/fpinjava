package com.fpinkotlin.makingjavafunctional.exercise03_14

import org.junit.Assert.assertEquals
import org.junit.Test


class RangeTest {

	@Test
	fun testRange() {
		assertEquals("[]", range(0, 0).toString())
		assertEquals("[0]", range(0, 1).toString())
		assertEquals("[0, 1, 2, 3, 4]", range(0, 5).toString())
		assertEquals("[]", range(5, 1).toString())
	}
}
