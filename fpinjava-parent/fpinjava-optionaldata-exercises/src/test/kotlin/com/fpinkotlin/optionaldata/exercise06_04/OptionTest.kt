package com.fpinkotlin.optionaldata.exercise06_04

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	@Test
	fun testFlatMap() {
		val option = some(2)
		assertEquals("Some(4)", option.flatMap { x -> some(x * 2) }.toString())
	}

	@Test
	fun testFlatMapNone() {
		val option = none<Int>()
		assertEquals("None", option.flatMap { x -> some(x * 2) }.toString())
	}

}
