package com.fpinkotlin.handlingerrors.exercise07_14

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

val parseWithRadix = { radix: Int -> { string: String -> Integer.parseInt(string, radix) } }

fun failTest(o: Any) = fail()

class ResultTest {

	@Test
	fun testMap2SuccessSuccess() {
		val radix = 16
		val string = "AEF15DB"
		assertEquals(Result.success(Integer.parseInt(string, radix)).toString(),
				Result.map2(Result.success(radix), Result.success(string), parseWithRadix).toString())
	}

	@Test(expected = IllegalStateException::class)
	fun testMap2SuccessFailure() {
		val radix = 16
		Result.map2(Result.success(radix),
				Result.failure<String>("error"), parseWithRadix).forEachOrThrow { failTest(it) }
	}

	@Test(expected = IllegalStateException::class)
	fun testMap2FailureSuccess() {
		val string = "AEF15DB"
		Result.map2(Result.failure<Int>("error"),
				Result.success(string), parseWithRadix).forEachOrThrow { failTest(it) }
	}

	@Test
	fun testMap2EmptySuccess() {
		val string = "AEF15DB"
		Result.map2(Result.empty<Int>(),
				Result.success(string), parseWithRadix).forEachOrThrow { failTest(it) }
	}

	@Test
	fun testMap2SuccessEmpty() {
		val radix = 16
		Result.map2(Result.success(radix),
				Result.empty<String>(), parseWithRadix).forEachOrThrow { failTest(it) }
	}
}
