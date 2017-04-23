package com.fpinkotlin.functions.exercise02_09

import org.junit.Assert.assertEquals
import org.junit.Test

fun <A, B, C, D> func(a: A, b: B, c: C, d: D): String {
	return String.format("%s, %s, %s, %s", a, b, c, d)
}

class FunctionExamplesTest {
	@Test
	fun testF() {
		assertEquals(func("A", "B", "C", "D"), "A".f<String, String, String, String>()("B")("C")("D"))
	}
}
