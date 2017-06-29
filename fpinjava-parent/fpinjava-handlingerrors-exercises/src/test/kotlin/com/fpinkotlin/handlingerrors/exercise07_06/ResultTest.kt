package com.fpinkotlin.handlingerrors.exercise07_06

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ResultTest {

	val empty = Result.empty<Int>()
	val failure = Result.failure<Int>("Failure message")
	val success = Result.success(4)
	val even: (Int) -> Boolean = { x -> x % 2 == 0 }
	val odd: (Int) -> Boolean = { x -> !even(x) }

	@Test
	fun testExistsFunctionOfVBooleanEmpty() {
		assertFalse(empty.exists(even))
		assertFalse(empty.exists(odd))
	}

	@Test
	fun testExistsFunctionOfVBooleanFailure() {
		assertFalse(failure.exists(even))
		assertFalse(failure.exists(odd))
	}

	@Test
	fun testExistsFunctionOfVBooleanSuccess() {
		assertTrue(success.exists(even))
		assertFalse(success.exists(odd))
	}
}
