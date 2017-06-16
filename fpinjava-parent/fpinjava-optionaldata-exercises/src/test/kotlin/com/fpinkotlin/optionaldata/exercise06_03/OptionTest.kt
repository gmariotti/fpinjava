package com.fpinkotlin.optionaldata.exercise06_03

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	@Test
	fun testMap() {
		val option = some(2)
		assertEquals("Some(4)", option.map { x -> x * 2 }.toString())
	}

	@Test
	fun testMapNone() {
		val option = none<Int>()
		assertEquals("None", option.map { x -> x * 2 }.toString())
	}
}
