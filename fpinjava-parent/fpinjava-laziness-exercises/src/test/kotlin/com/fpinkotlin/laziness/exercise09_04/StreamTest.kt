package com.fpinkotlin.laziness.exercise09_04

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test


class StreamTest {

	private var evaluated = list<Int>()

	private fun evaluate(n: Int): Int {
		evaluated = evaluated.cons(n)
		return n
	}

	private val stream =
			cons({ evaluate(1) },
					cons({ evaluate(2) },
							cons({ evaluate(3) },
									cons({ evaluate(4) },
											cons({ evaluate(5) }, empty<Int>())))))

	@Test
	fun testTakeWhile() {
		evaluated = list<Int>()
		assertEquals("[NIL]", evaluated.toString())
		val result = stream.takeWhile({ x -> x < 3 })
		assertEquals("[1, NIL]", evaluated.toString())
		assertEquals("[1, 2, NIL]", result.toList().toString())
	}

	@Test
	fun testTakeWhileEmpty() {
		assertEquals("[NIL]", empty<Int>().takeWhile({ x -> x < 4 }).toList().toString())
	}

	@Test
	fun testLongTakeWhileTrue() {
		val stream = from(0)
		val result = stream.takeWhile({ x -> x < 500000 }).drop(200000).take(5)
		assertEquals("[200000, 200001, 200002, 200003, 200004, NIL]", result.toList().toString())
	}


	@Test
	fun testLongTakeWhileFalse() {
		val stream = from(0)
		val result = stream.takeWhile({ x -> x < 0 }).drop(200000).take(5)
		assertEquals("[NIL]", result.toList().toString())
	}
}
