package com.fpinkotlin.functions.exercise02_08

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionExamplesTest {

	@Test
	fun testPartialB() {
		val f: (Int) -> (Double) -> (Double) = { a -> { b -> a * (1 + b / 100) } }
		val g = f partialB 16.65

		assertEquals(f(89)(16.65), g(89), 0.0)
		assertEquals(f(0)(16.65), g(0), 0.0)
		assertEquals(f(1623)(16.65), g(1623), 0.0)
	}
}
