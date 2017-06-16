package com.fpinkotlin.optionaldata.exercise06_02

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	fun getDefault(): Nothing = throw IllegalStateException()

	@Test
	fun testGetOrElse() {
		val option = some(2)
		assertEquals(2, option.getOrElse { getDefault() })
	}

	@Test(expected = IllegalStateException::class)
	fun testGetOrElseNone() {
		val option = none<Int>()
		assertEquals(Integer.valueOf(0), option.getOrElse { getDefault() })
	}
}
