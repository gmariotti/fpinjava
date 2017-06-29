package com.fpinkotlin.handlingerrors.exercise07_12

import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {

	private val parseIntResult = Result.lift { x: String -> Integer.parseInt(x) }

	@Test
	fun testLift() {
		assertEquals(Result.success(345).toString(),
				parseIntResult(Result.success("345")).toString())
	}

	@Test
	fun testLiftEmpty() {
		assertEquals(Result.empty<Any>(), parseIntResult(Result.empty<String>()))
	}
}
