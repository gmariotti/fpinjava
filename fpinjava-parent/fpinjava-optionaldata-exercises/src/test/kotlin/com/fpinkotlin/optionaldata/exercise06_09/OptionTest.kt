package com.fpinkotlin.optionaldata.exercise06_09

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {


	private val parseIntOption = lift<String, Int> { it.toInt() }

	@Test
	fun testLift() {
		assertEquals(some(345).toString(), parseIntOption(some("345")).toString())
	}

	@Test
	fun testLiftNone() {
		assertEquals(none<Any>(), parseIntOption(none<String>()))
	}

	@Test
	fun testLiftException() {
		assertEquals(none<Any>(), parseIntOption(some("abcd")))
	}
}
