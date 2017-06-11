package com.fpinkotlin.recursion.exercise04_07

import com.fpinkotlin.recursion.exercise04_04.range
import org.junit.Assert.assertEquals
import org.junit.Test

class ComposeAllTest {

	val add: (Int) -> Int = { y -> y + 1 }

	@Test
	fun testComposeAll() {
		assertEquals(500, composeAll(range(0, 500).map { add })(0))
	}

	@Test
	fun testComposeAllLeft() {
		assertEquals(500, composeAllViaFoldLeft(range(0, 500).map { add })(0))
	}

	@Test
	fun testComposeAllRight() {
		assertEquals(500, composeAllViaFoldRight(range(0, 500).map { add })(0))
	}
}
