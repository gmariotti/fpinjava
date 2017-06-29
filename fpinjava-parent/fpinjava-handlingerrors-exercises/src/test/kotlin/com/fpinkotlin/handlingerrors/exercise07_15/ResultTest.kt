package com.fpinkotlin.handlingerrors.exercise07_15

import org.junit.Assert.assertEquals
import org.junit.Test


class ResultTest {

	@Test
	fun testfoldLeftSuccess() {
		val result = Result.success('a')
		assertEquals("_a", result.foldLeft("_") { x -> { y -> x + y } })
	}

	@Test
	fun testfoldRightSuccess() {
		val result = Result.success('a')
		assertEquals("a_", result.foldRight("_") { x -> { y -> x + y } })
	}

	@Test
	fun testFoldLeftFailure() {
		val result = Result.failure<Char>("error")
		assertEquals("_", result.foldLeft("_") { x -> { y -> x + y } })
	}

	@Test
	fun testFoldRightFailure() {
		val result = Result.failure<Char>("error")
		assertEquals("_", result.foldRight("_") { x -> { y -> x + y } })
	}
}
