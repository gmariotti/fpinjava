package com.fpinkotlin.lists.exercise05_01

import org.junit.Test
import org.junit.Assert.assertEquals

class ListTest {

	@Test
	fun testCons() {
		assertEquals("a", list<String>().cons("a").head)
		assertEquals("a", list("b", "c", "d").cons("a").head)
		assertEquals("b", list("b", "c", "d").cons("a").tail.head)
	}
}
