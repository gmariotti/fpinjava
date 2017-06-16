package com.fpinkotlin.lists.exercise05_13

import com.fpinkotlin.lists.exercise05_10.list
import org.junit.Assert.assertEquals
import org.junit.Test

class FoldsTest {

	private fun addIS(i: Int, s: String): String {
		return "($i + $s)"
	}

	private fun addSI(s: String, i: Int): String {
		return "($s + $i)"
	}

	@Test
	fun testFoldRightViaFoldLeft() {
		val list = list(1, 2, 3, 4, 5)
		val identity = "0"
		val f: (Int) -> (String) -> String = { x -> { y -> addIS(x, y) } }
		assertEquals("(1 + (2 + (3 + (4 + (5 + 0)))))", foldRightViaFoldLeft(list, identity, f))
	}

	@Test
	fun testFoldLeftViaFoldRight() {
		val list = list(1, 2, 3, 4, 5)
		val identity = "0"
		val f: (String) -> (Int) -> String = { x -> { y -> addSI(x, y) } }
		assertEquals("(((((0 + 1) + 2) + 3) + 4) + 5)", foldLeftViaFoldRight(list, identity, f))
	}
}
