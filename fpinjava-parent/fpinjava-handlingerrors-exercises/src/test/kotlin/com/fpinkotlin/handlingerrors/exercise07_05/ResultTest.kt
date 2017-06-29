package com.fpinkotlin.handlingerrors.exercise07_05

import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {

	val empty = Result.empty<Int>()
	val failure = Result.failure<Int>("Failure message")
	val success = Result.success(4)
	val even: (Int) -> Boolean = { x -> x % 2 == 0 }
	val odd: (Int) -> Boolean = { x -> !even(x) }

	@Test
	fun testFilterFunctionOfVBooleanEmpty() {
		assertEquals("Empty()", empty.filter(even).toString())
		assertEquals("Empty()", empty.filter(odd).toString())
	}

	@Test
	fun testFilterFunctionOfVBooleanStringEmpty() {
		assertEquals("Empty()", empty.filter(even, "Condition is not matched").toString())
		assertEquals("Empty()", empty.filter(odd, "Condition is not matched").toString())
	}

	@Test
	fun testFilterFunctionOfVBooleanFailure() {
		assertEquals("Failure(Failure message)", failure.filter(even).toString())
		assertEquals("Failure(Failure message)", failure.filter(odd).toString())
	}

	@Test
	fun testFilterFunctionOfVBooleanStringFailure() {
		assertEquals("Failure(Failure message)",
				failure.filter(even, "Condition is not matched").toString())
		assertEquals("Failure(Failure message)",
				failure.filter(odd, "Condition is not matched").toString())
	}

	@Test
	fun testFilterFunctionOfVBooleanSuccess() {
		assertEquals("Success(4)", success.filter(even).toString())
		assertEquals("Failure(Condition not matched)", success.filter(odd).toString())
	}

	@Test
	fun testFilterFunctionOfVBooleanStringSuccess() {
		assertEquals("Success(4)", success.filter(even, "The number is not even").toString())
		assertEquals("Failure(The number is not even)",
				success.filter(odd, "The number is not even").toString())
	}
}
