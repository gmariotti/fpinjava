package com.fpinkotlin.optionaldata.exercise06_08

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	private val upperOption = lift<String, String> { it.toUpperCase() }

	@Test
	fun testLift() {
		assertEquals(some("STRING").toString(), upperOption(some("string")).toString())
	}

	@Test
	fun testLiftNone() {
		assertEquals(none<String>(), upperOption(none<String>()))
	}
}
