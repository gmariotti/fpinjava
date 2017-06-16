package com.fpinkotlin.optionaldata.exercise06_01

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	@Test
	fun testGetOrElse() {
		val option = some(2)
		assertEquals(2, option.getOrElse(0))
	}

	@Test
	fun testGetOrElseNone() {
		val option = none<Int>()
		assertEquals(0, option.getOrElse(0))
	}
}
