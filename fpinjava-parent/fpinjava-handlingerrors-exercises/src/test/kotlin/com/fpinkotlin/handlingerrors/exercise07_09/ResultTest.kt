package com.fpinkotlin.handlingerrors.exercise07_09

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Non functional method tested with a non functional test!
 */
class ResultTest {

	class TestResult {
		var value: Int = 0
	}

	val empty= Result.empty<Int>()
	val failure = Result.failure<Int>("failure message")
	val success = Result.success(4)

	@Test
	fun testForEachEmpty() {
		val tr = TestResult()
		empty.forEach { tr.value = it }
		assertEquals(0, tr.value.toLong())
	}

	@Test
	fun testForEachFailure() {
		val tr = TestResult()
		failure.forEach { tr.value = it }
		assertEquals(0, tr.value.toLong())
	}

	@Test
	fun testForEachSuccess() {
		val tr = TestResult()
		success.forEach { tr.value = it }
		assertEquals(4, tr.value.toLong())
	}
}
