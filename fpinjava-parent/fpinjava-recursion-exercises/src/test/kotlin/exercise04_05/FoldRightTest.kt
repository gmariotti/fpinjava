package exercise04_05

import org.junit.Assert.assertEquals
import org.junit.Test

class FoldRightTest {

	@Test
	fun testFoldRight() {
		val list = listOf(1, 2, 3, 4, 5)
		val identity = "0"
		val f: (Int) -> (String) -> (String) = { i -> { s -> "($i + $s)" } }
		assertEquals("(1 + (2 + (3 + (4 + (5 + 0)))))", foldRight(list, identity, f))
	}
}
