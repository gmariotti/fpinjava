package com.fpinkotlin.handlingerrors.exercise07_16

import org.junit.Assert.assertEquals
import org.junit.Test


class ResultTest {

	@Test
	fun testGetOrElseViaFoldLeftSuccess() {
		val result = Result.success(1)
		assertEquals(1, result.getOrElseViaFoldLeft(0))
	}

	@Test
	fun testGetOrElseViaFoldLeftEmpty() {
		val result = Result.empty<Int>()
		assertEquals(0, result.getOrElseViaFoldLeft(0))
	}

	@Test
	fun testGetOrElseViaFoldRightSuccess() {
		val result = Result.success(1)
		assertEquals(1, result.getOrElseViaFoldRight(0))
	}

	@Test
	fun testGetOrElseViaFoldRightEmpty() {
		val result = Result.empty<Int>()
		assertEquals(0, result.getOrElseViaFoldRight(0))
	}
}
