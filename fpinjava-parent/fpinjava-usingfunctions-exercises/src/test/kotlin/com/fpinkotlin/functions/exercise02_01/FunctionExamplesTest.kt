package com.fpinkotlin.functions.exercise02_01

import org.junit.Test

import org.junit.Assert.assertEquals

class FunctionExamplesTest {

	@Test
	fun testCompose() {
		assertEquals(6, triple(2))
		assertEquals(4, square(2))
		assertEquals(36, square(triple(2)))
		assertEquals(27, (triple compose square)(3))
	}
}
