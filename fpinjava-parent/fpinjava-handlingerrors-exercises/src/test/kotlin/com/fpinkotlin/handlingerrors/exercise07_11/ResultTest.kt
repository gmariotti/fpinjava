package com.fpinkotlin.handlingerrors.exercise07_11

import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {

	class TestResult {
		var value: Int = 0
	}

	val empty = Result.empty<Int>()
	val failure = Result.failure<Int>("failure message")
	val success = Result.success(4)

	@Test
	fun testForEachOrExceptionEmpty() {
		val tr = TestResult()
		empty.forEachOrException { tr.value = it }.forEach { tr.value = 12 }
		assertEquals(0, tr.value.toLong())
	}

	@Test
	fun testForEachOrExceptionFailure() {
		val tr = TestResult()
		failure.forEachOrException { tr.value = it }.forEach { tr.value = 12 }
		assertEquals(12, tr.value.toLong())
	}

	@Test
	fun testForEachOrExceptionSuccess() {
		val tr = TestResult()
		success.forEachOrException { tr.value = it }.forEach { tr.value = 12 }
		assertEquals(4, tr.value.toLong())
	}
}
