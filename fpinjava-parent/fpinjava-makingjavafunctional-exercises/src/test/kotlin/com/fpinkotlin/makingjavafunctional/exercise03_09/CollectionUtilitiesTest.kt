package com.fpinkotlin.makingjavafunctional.exercise03_09

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionUtilitiesTest {

	@Test
	fun testPrepend() {
		assertEquals("[0, 1, 2, 3]", prepend("0", list("1", "2", "3")).toString())
		assertEquals("[0]", prepend("0", list<String>()).toString())
	}

	@Test
	fun testReverse() {
		assertEquals("[]", reverse(list<Any>()).toString())
		assertEquals("[1]", reverse(list(1)).toString())
		assertEquals("[3, 2, 1]", reverse(list(1, 2, 3)).toString())
	}
}
