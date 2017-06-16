package com.fpinkotlin.optionaldata.exercise06_06

import com.fpinjava.optionaldata.exercise06_06.Option

import org.junit.Test

import org.junit.Assert.assertEquals

class OptionTest {

	@Test
	fun testFilterTrue() {
		val option = some(2)
		assertEquals("Some(2)", option.filter { x -> x % 2 == 0 }.toString())
	}

	@Test
	fun testFilterFalse() {
		val option = some(3)
		assertEquals("None", option.filter { x -> x % 2 == 0 }.toString())
	}

	@Test
	fun testFilterNone() {
		val option = none<Int>()
		assertEquals("None", option.filter { x -> x % 2 == 0 }.toString())
	}
}
