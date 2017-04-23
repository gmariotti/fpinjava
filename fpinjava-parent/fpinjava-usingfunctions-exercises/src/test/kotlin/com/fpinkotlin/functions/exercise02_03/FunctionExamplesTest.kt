package com.fpinkotlin.functions.exercise02_03

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionExamplesTest {

	@Test
	fun test() {
		assertEquals(8, add(3)(5))
		assertEquals(15, mult(3)(5))
	}
}
