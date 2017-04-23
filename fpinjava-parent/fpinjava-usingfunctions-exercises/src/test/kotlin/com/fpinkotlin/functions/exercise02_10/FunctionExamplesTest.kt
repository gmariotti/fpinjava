package com.fpinkotlin.functions.exercise02_10

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionExamplesTest {

	@Test
	fun testCurry() {
		val f: (Pair<Int, Double>) -> Double = { x -> x.first * (1 + x.second / 100) }
		val g = f.curry()

		assertEquals(f(89 to 7.0), g(89)(7.0), 0.0)
		assertEquals(f(27 to 0.0), g(27)(0.0), 0.0)
		assertEquals(f(1623 to 16.65), g(1623)(16.65), 0.0)
	}
}
