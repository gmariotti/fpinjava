package com.fpinkotlin.laziness.listing09_05

import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

	@Test
	fun testStream() {
		val stream = from(1)
		assertEquals(Integer.valueOf(1), stream.head)
		assertEquals(Integer.valueOf(2), stream.tail.head)
		assertEquals(Integer.valueOf(3), stream.tail.tail.head)
	}
}
