package com.fpinkotlin.handlingerrors.exercise07_01

import org.junit.Assert.assertEquals
import org.junit.Test

class EitherTest {

	@Test
	fun testMapRight() {
		val either = right<String, Int>(2)
		assertEquals("Right(4)", either.map { x -> x * 2 }.toString())
	}

	@Test
	fun testMapLeft() {
		val either = left<String, Int>("error")
		assertEquals("Left(error)", either.map { x -> x * 2 }.toString())
	}
}
