package com.fpinkotlin.handlingerrors.exercise07_13

import org.junit.Assert.assertEquals
import org.junit.Test

val parseWithRadix = { radix: Int -> { string: String -> Integer.parseInt(string, radix) } }

val valueOf = { data: CharArray -> { offset: Int -> { count: Int -> String(data, offset, count) } } }


class ResultTest {

	@Test
	fun testLift2() {
		val radix = 16
		val string = "AEF15DB"
		assertEquals(Result.success(Integer.parseInt(string, radix)),
				Result.lift2(parseWithRadix)(Result.success(radix))(Result.success(string)))
	}

	@Test
	fun testLift3() {
		val data = Result.of("Hello, World!".toCharArray())
		val offset = Result.of(7)
		val count = Result.of(5)
		assertEquals(Result.success("World"), Result.lift3(valueOf)(data)(offset)(count))
	}
}
