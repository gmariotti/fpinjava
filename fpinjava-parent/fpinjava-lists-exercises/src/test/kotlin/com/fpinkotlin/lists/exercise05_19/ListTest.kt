package com.fpinkotlin.lists.exercise05_19

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testMap() {
		assertEquals("[2, 3, 4, 5, NIL]", list(1, 2, 3, 4).map { x -> x + 1 }.toString())
		assertEquals("[0.0, 1.0, 2.0, 3.0, NIL]",
				list(1.0, 2.0, 3.0).map { x -> x.toString() }.cons("0.0").toString())
	}
}
