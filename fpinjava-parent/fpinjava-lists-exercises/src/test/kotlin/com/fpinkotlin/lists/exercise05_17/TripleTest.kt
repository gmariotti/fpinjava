package com.fpinkotlin.lists.exercise05_17

import com.fpinkotlin.lists.exercise05_16.list
import org.junit.Assert.assertEquals
import org.junit.Test

class TripleTest {

	@Test
	fun testTriple() {
		assertEquals("[3, 6, 9, 12, NIL]", triple(list(1, 2, 3, 4)).toString())
	}
}
