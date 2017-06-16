package com.fpinkotlin.optionaldata.exercise06_05

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	@Test
	fun testOrElse() {
		val option = some(2)
		assertEquals("Some(4)",
				option.map { x -> x * 2 }.orElse { throw RuntimeException() }.toString())
	}

	@Test(expected = RuntimeException::class)
	fun testOrElseNone() {
		val option = none<Int>()
		option.map { x -> x * 2 }.orElse { throw RuntimeException() }
	}
}
