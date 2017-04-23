package com.fpinkotlin.functions.exercise02_11

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionExamplesTest {

	@Test
	fun testReverseArgs() {
		val f: (Int) -> (Double) -> (Double) = { a -> { b -> a * (1 + b / 100) } }
		val g = f.reverseArgs()

		assertEquals(f(89)(7.0), g(7.0)(89), 0.0)
		assertEquals(f(27)(0.0), g(0.0)(27), 0.0)
		assertEquals(f(1623)(16.65), g(16.65)(1623), 0.0)
	}
}
