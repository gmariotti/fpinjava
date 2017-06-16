package com.fpinkotlin.optionaldata.exercise06_10

import org.junit.Assert.assertEquals
import org.junit.Test

class OptionTest {

	val parseWithRadix: (Int) -> (String) -> Int = { radix -> { string -> string.toInt(radix) } }

	@Test
	fun testMap2() {
		val radix = 16
		val string = "AEF15DB"
		assertEquals(some(Integer.parseInt(string, radix)).toString(),
				map2(some(radix), some(string), parseWithRadix).toString())
	}
}
