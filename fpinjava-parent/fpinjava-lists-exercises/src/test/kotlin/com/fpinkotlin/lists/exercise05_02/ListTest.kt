package com.fpinkotlin.lists.exercise05_02

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test(expected = IllegalStateException::class)
	fun testSetHeadNil() {
		list<String>().setHead("d")
	}

	@Test
	fun testSetHead() {
		assertEquals("d", list("a", "b", "c").setHead("d").head)
		assertEquals("b", list("a", "b", "c").setHead("d").tail.head)
	}
}
