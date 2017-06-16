package com.fpinkotlin.optionaldata.exercise06_12

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	val parseWithRadix: (Int) -> (String) -> Int = { radix -> { string -> string.toInt(radix) } }

	@Test
	fun testSequence() {
		val parse16 = hlift(parseWithRadix(16))
		val list = list("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
		assertEquals("Some([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, NIL])", sequence(list.map(parse16)).toString())
	}

	@Test
	fun testSequenceError() {
		val parse8 = hlift(parseWithRadix(8))
		val list = list("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
		assertEquals("None", sequence(list.map(parse8)).toString())
	}
}
