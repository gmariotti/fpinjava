package com.fpinkotlin.handlingerrors.exercise07_03

import org.junit.Assert.assertEquals
import org.junit.Test

fun getDefault(): Int = throw IllegalStateException()

class EitherTest {

	@Test
	fun testGetOrElseRight() {
		val either = right<String, Int>(2)
		assertEquals(2, either.getOrElse { getDefault() })
	}

	@Test(expected = IllegalStateException::class)
	fun testGetOrElseLeft() {
		val either = left<String, Int>("error")
		assertEquals(0, either.getOrElse { getDefault() })
	}

	@Test
	fun testOrElseRight() {
		val either = right<String, Int>(2)
		assertEquals("Right(4)",
				either.map { it * 2 }.orElse { throw RuntimeException() }.toString())
	}

	@Test(expected = RuntimeException::class)
	fun testOrElseLeft() {
		val either = left<String, Int>("error")
		either.map { it * 2 }.orElse { throw RuntimeException() }
	}
}
