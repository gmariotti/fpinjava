package com.fpinkotlin.laziness.exercise09_05

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
	fun testDropWhile() {
		evaluated = list<Int>()
		assertEquals("[NIL]", evaluated.toString())
		val result = stream.dropWhile({ x -> x < 3 })
		assertEquals("[3, 2, 1, NIL]", evaluated.toString())
		assertEquals("[3, 4, 5, NIL]", result.toList().toString())
	}

	@Test
	fun testDropWhileEmpty() {
		assertEquals("[NIL]", empty<Int>().dropWhile({ x -> x < 4 }).toList().toString())
	}

	@Test
	fun testLongDropWhileTrue() {
		val stream = from(0)
		val result = stream.dropWhile({ x -> x < 200000 }).take(5)
		assertEquals("[200000, 200001, 200002, 200003, 200004, NIL]", result.toList().toString())
	}

	@Test
	fun testLongDropWhileFalse() {
		val stream = from(0)
		val result = stream.dropWhile({ x -> x < 0 }).take(5)
		assertEquals("[0, 1, 2, 3, 4, NIL]", result.toList().toString())
	}

}
