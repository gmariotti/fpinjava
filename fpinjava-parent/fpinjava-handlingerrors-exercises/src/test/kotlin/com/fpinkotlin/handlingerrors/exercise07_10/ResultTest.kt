package com.fpinkotlin.handlingerrors.exercise07_10

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
	fun testForEachOrThrowEmpty() {
		val tr = TestResult()
		empty.forEachOrThrow { tr.value = it }
		assertEquals(0, tr.value.toLong())
	}

	@Test(expected = IllegalStateException::class)
	fun testForEachOrThrowFailure() {
		val tr = TestResult()
		failure.forEachOrThrow { tr.value = it }
	}

	@Test
	fun testForEachOrThrowSuccess() {
		val tr = TestResult()
		success.forEachOrThrow { tr.value = it }
		assertEquals(4, tr.value.toLong())
	}

}
