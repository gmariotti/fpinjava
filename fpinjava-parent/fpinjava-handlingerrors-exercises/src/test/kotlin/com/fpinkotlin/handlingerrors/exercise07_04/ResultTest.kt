package com.fpinkotlin.handlingerrors.exercise07_04

import org.junit.Assert.assertEquals
import org.junit.Test

fun getDefault(): Int = throw IllegalStateException()

class ResultTest {

	@Test
	fun testGetOrElseSuccess() {
		val result = success(2)
		assertEquals(2, result.getOrElse { getDefault() })
	}

	@Test(expected = IllegalStateException::class)
	fun testGetOrElseFailure() {
		val result = failure<Int>("error")
		result.getOrElse { getDefault() }
	}

	@Test
	fun testOrElseSuccess() {
		val result = success(2)
		assertEquals("Success(4)",
				result.map { it * 2 }.orElse { throw RuntimeException() }.toString())
	}

	@Test(expected = RuntimeException::class)
	fun testOrElseFailure() {
		val result = failure<Int>("error")
		result.map { it * 2 }.orElse { throw RuntimeException() }
	}

	@Test
	fun testMapSuccess() {
		val result = success(2)
		assertEquals("Success(4)", result.map { it * 2 }.toString())
	}

	@Test
	fun testMapFailure() {
		val result = failure<Int>("error")
		assertEquals("Failure(error)", result.map { it * 2 }.toString())
	}

	@Test
	fun testFlatMapSuccess() {
		val result = success(2)
		assertEquals("Success(4)", result.flatMap { success(it * 2) }.toString())
	}

	@Test
	fun testFlatMapFailure() {
		val result = failure<Int>("error")
		assertEquals("Failure(error)", result.flatMap { success(it * 2) }.toString())
	}
}
