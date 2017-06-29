package com.fpinkotlin.handlingerrors.exercise07_07

import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {

	internal var empty = Result.empty<Int>()
	internal var failure = Result.failure<Int>("failure message")
	internal var success = Result.success(4)

	@Test
	fun testMapFailureStringEmpty() {
		assertEquals("Empty()", empty.mapFailure("no data").toString())
	}

	@Test
	fun testMapFailureStringFailure() {
		assertEquals("Failure(no data)", failure.mapFailure("no data").toString())
	}

	@Test
	fun testMapFailureStringSuccess() {
		assertEquals("Success(4)", success.mapFailure("no data").toString())
	}
}
