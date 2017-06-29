package com.fpinkotlin.handlingerrors.exercise07_05

import org.junit.Assert.assertEquals
import org.junit.Test

fun getDefault(): Int = throw IllegalStateException()

class EmptyTest {

	@Test
	fun testGetOrElseSuccess() {
		val result = Result.success(2)
		assertEquals(2, result.getOrElse { getDefault() })
	}

	@Test(expected = IllegalStateException::class)
	fun testGetOrElseEmpty() {
		val result = Result.empty<Int>()
		assertEquals(0, result.getOrElse { getDefault() })
	}

	@Test(expected = IllegalStateException::class)
	fun testGetOrElseFailure() {
		val result = Result.failure<Int>("error")
		result.getOrElse { getDefault() }
	}

	@Test
	fun testOrElseSuccess() {
		val result = Result.success(2)
		assertEquals("Success(4)",
				result.map { it * 2 }.orElse { throw RuntimeException() }.toString())
	}

	@Test(expected = RuntimeException::class)
	fun testOrElseEmpty() {
		val result = Result.empty<Int>()
		result.map { it * 2 }.orElse { throw RuntimeException() }.toString()
	}

	@Test(expected = RuntimeException::class)
	fun testOrElseFailure() {
		val result = Result.failure<Int>("error")
		result.map { it * 2 }.orElse { throw RuntimeException() }
	}

	@Test
	fun testMapSuccess() {
		val result = Result.success(2)
		assertEquals("Success(4)", result.map { it * 2 }.toString())
	}

	@Test
	fun testMapFailure() {
		val result = Result.failure<Int>("error")
		assertEquals("Failure(error)", result.map { it * 2 }.toString())
	}

	@Test
	fun testMapEmpty() {
		val result = Result.empty<Int>()
		assertEquals("Empty()", result.map { it * 2 }.toString())
	}

	@Test
	fun testFlatMapSuccess() {
		val result = Result.success(2)
		assertEquals("Success(4)", result.flatMap { Result.success(it * 2) }.toString())
	}

	@Test
	fun testFlatMapEmpty() {
		val result = Result.empty<Int>()
		assertEquals("Empty()", result.flatMap { Result.success(it * 2) }.toString())
	}

	@Test
	fun testFlatMapFailure() {
		val result = Result.failure<Int>("error")
		assertEquals("Failure(error)", result.flatMap { Result.success(it * 2) }.toString())
	}
}
