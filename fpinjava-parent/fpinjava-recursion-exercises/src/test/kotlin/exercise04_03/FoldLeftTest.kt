package exercise04_03

import org.junit.Assert.assertEquals
import org.junit.Test

class FoldLeftTest {

	@Test
	fun testFoldLeft() {
		val list = listOf(1, 2, 3, 4, 5)
		val identity = "0"
		val f: (String) -> (Int) -> String = { x -> { y -> "($x + $y)" } }
		assertEquals("(((((0 + 1) + 2) + 3) + 4) + 5)", foldLeft(list, identity, f))
	}
}
