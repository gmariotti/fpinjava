package com.fpinkotlin.lists.exercise05_14

import org.junit.Assert.assertEquals
import org.junit.Test

class ListTest {

	@Test
	fun testFoldRight() {
		val list = list(1, 2, 3, 4, 5)
		val identity = "0"
		val f: (Int) -> (String) -> String = { i -> { s -> "($i + $s)" } }
		assertEquals("(1 + (2 + (3 + (4 + (5 + 0)))))", list.foldRight(identity, f))
	}
}
