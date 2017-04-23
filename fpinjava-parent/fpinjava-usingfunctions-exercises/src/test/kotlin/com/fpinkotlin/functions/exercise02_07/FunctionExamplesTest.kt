package com.fpinkotlin.functions.exercise02_07

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionExamplesTest {

	@Test
	fun testPartialA() {
		val f: (Int) -> (Double) -> (Double) = { a -> { b -> a * (1 + b / 100) } }
		val g = f partialA 89

		assertEquals(f(89)(7.0), g(7.0), 0.0)
		assertEquals(f(89)(0.0), g(0.0), 0.0)
		assertEquals(f(89)(16.65), (f partialA 89)(16.65), 0.0)
	}
}
