package com.fpinkotlin.laziness.exercise09_02

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test


class StreamTest {

	private var evaluated = list<Int>()

	private fun evaluate(n: Int): Int {
		evaluated = evaluated.cons(n)
		return n
	}

	@Test
	fun testToList() {
		val stream =
				cons({ evaluate(1) },
						cons({ evaluate(2) },
								cons({ evaluate(3) },
										cons({ evaluate(4) },
												cons({ evaluate(5) }, { empty() })))))
		assertEquals("[NIL]", evaluated.toString())
		assertEquals("[1, 2, 3, 4, 5, NIL]", stream.toList().toString())
	}

	@Test
	fun testToListEmpty() {
		assertEquals("[NIL]", empty<Any>().toList().toString())
	}
}
