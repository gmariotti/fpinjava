package com.fpinkotlin.handlingerrors.exercise07_02

import org.junit.Assert.assertEquals
import org.junit.Test

class EitherTest {

	@Test
	fun testFlatMapRight() {
		val either = right<String, Int>(2)
		assertEquals("Right(4)",
				either.flatMap { x -> right<String, Int>(x * 2) }.toString())
	}

	@Test
	fun testFlatMapLeft() {
		val either = left<String, Int>("error")
		assertEquals("Left(error)",
				either.flatMap { x -> right<String, Int>(x * 2) }.toString())
	}
}
