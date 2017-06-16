package com.fpinkotlin.lists.exercise05_22

import com.fpinkotlin.lists.exercise05_21.list
import org.junit.Assert.assertEquals
import org.junit.Test

class FilterTest {

	@Test
	fun testFilterViaFlatMap() {
		assertEquals("[2, 4, 6, NIL]",
				filterViaFlatMap(list(1, 2, 3, 4, 5, 6)) { x -> x % 2 == 0 }.toString())
	}

}
