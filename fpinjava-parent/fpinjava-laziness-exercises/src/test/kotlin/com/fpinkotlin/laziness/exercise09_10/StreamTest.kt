package com.fpinkotlin.laziness.exercise09_10

import com.fpinkotlin.common.List
import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

    private lateinit var evaluated: List<Int>

    private fun evaluate(n: Int): Int {
        evaluated = evaluated.cons(n)
        return n
    }

    private val stream = cons({ evaluate(1) },
        cons({ evaluate(2) },
            cons({ evaluate(3) },
                cons({ evaluate(4) },
                    cons({ evaluate(5) },
                        empty()))))
    )

    @Test
    fun testMap() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream.map { it * 3 }) {
            assertEquals(3, head)
            assertEquals(6, tail.head)
            assertEquals(9, tail.tail.head)
            assertEquals("[3, 2, 1, NIL]", evaluated.toString())
            assertEquals("[3, 6, 9, 12, 15, NIL]", toList().toString())
        }
    }

    @Test
    fun testMapEmpty() {
        assertEquals("[NIL]", empty<Int>().map { it * 3 }.toList().toString())
    }

    @Test
    fun testLongMap() {
        with(from(0)) {
            val result = map { it * 2 }.drop(200000).take(5)
            assertEquals("[400000, 400002, 400004, 400006, 400008, NIL]", result.toList().toString())
        }
    }
}
