package com.fpinkotlin.lists.exercise05_18

import com.fpinkotlin.lists.exercise05_16.list
import org.junit.Assert.assertEquals
import org.junit.Test

class DoubleToStringTest {

	@Test
	fun testDoubleToString() {
		assertEquals("[0.0, 1.0, 2.0, 3.0, NIL]",
				doubleToString(list(1.0, 2.0, 3.0)).cons("0.0").toString())
	}
}
