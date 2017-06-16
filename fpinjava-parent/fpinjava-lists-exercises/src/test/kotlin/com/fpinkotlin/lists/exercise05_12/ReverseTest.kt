package com.fpinkotlin.lists.exercise05_12

import com.fpinkotlin.lists.exercise05_10.list
import org.junit.Assert.assertEquals
import org.junit.Test

class ReverseTest {

	@Test
	fun testReverseViaFoldLeft() {
		assertEquals("[NIL]", reverseViaFoldLeft(list<String>()).toString())
		assertEquals("[3, 2, 1, NIL]", reverseViaFoldLeft(list(1, 2, 3)).toString())
	}
}
