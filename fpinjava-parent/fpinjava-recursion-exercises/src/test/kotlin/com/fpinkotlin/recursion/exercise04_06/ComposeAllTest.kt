package com.fpinkotlin.recursion.exercise04_06

import com.fpinjava.common.CollectionUtilities.map
import com.fpinjava.recursion.exercise04_04.Range.range
import org.junit.Assert.assertEquals
import org.junit.Test

class ComposeAllTest {

	@Test
	fun testComposeAll() {
		val add: (Int) -> Int = { y -> y + 1 }
		assertEquals(500,
				composeAll(map<Int, ((Int) -> Int)>(range(0, 500)) { add })(0))
	}
}
