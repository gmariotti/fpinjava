package com.fpinkotlin.lists.exercise05_07

import com.fpinkotlin.lists.exercise05_06.list
import org.junit.Assert.assertEquals
import org.junit.Test

class SumTest {

	@Test
	fun testSum() {
		assertEquals(0, sum(list<Int>()))
		assertEquals(6, sum(list(1, 2, 3)))
	}
}
