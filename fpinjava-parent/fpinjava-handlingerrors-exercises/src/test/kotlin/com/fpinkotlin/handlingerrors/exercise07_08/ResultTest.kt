package com.fpinkotlin.handlingerrors.exercise07_08

import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {

	@Test
	fun testOfTValue() {
		assertEquals("Success(4)", Result.of(4).toString())
	}

	@Test
	fun testOfTNull() {
		assertEquals("Empty()", Result.of(null).toString())
	}

	@Test
	fun testOfTStringValue() {
		assertEquals("Success(4)", Result.of(4, "no value").toString())
	}

	@Test
	fun testOfTStringNull() {
		assertEquals("Failure(no value)", Result.of(null, "no value").toString())
	}

	@Test
	fun testOfFunctionOfTBooleanTValueTrue() {
		assertEquals("Success(4)", Result.of(4) { it % 2 == 0 }.toString())
	}

	@Test
	fun testOfFunctionOfTBooleanTValueFalse() {
		assertEquals("Empty()", Result.of(5) { it % 2 == 0 }.toString())
	}

	@Test
	fun testOfFunctionOfTBooleanTException() {
		assertEquals("Failure(Exception while evaluating predicate: 4)",
				Result.of(4) { throw RuntimeException("exception") }.toString())
	}

	@Test
	fun testOfFunctionOfTBooleanTStringValueTrue() {
		assertEquals("Success(4)", Result.of(4, "odd") { it % 2 == 0 }.toString())
	}

	@Test
	fun testOfFunctionOfTBooleanTStringValueFalse() {
		assertEquals("Failure(odd)", Result.of(5, "odd") { it % 2 == 0 }.toString())
	}

	@Test
	fun testOfFunctionOfTBooleanTStringException() {
		assertEquals("Failure(Exception while evaluating predicate: odd)",
				Result.of(4, "odd") { throw RuntimeException("exception") }.toString())
	}

}
