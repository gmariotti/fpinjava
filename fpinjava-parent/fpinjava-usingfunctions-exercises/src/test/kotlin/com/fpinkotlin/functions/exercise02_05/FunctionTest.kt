package com.fpinkotlin.functions.exercise02_05

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionTest {

	@Test
	fun test() {
		val triple: (Int) -> (Int) = { x -> x * 3 }
		val square: (Int) -> (Int) = { x -> x * x }

		assertEquals(36, (square compose triple)(2))
	}
}
