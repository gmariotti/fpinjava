package com.fpinkotlin.functions.exercise02_12

import com.fpinkotlin.functions.exercise02_12.FunctionExamples.factorial0
import com.fpinkotlin.functions.exercise02_12.FunctionExamples.factorial1
import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionExamplesTest {

	@Test
	fun test() {
		assertEquals(3628800, factorial0(10))
		assertEquals(3628800, factorial1()(10))
	}
}
