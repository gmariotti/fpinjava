package com.fpinkotlin.laziness.exercise09_11

import com.fpinkotlin.common.List
import com.fpinkotlin.common.list
import org.junit.Test

import org.junit.Assert.assertEquals

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
    fun testFilter() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream.filter { it % 2 == 0 }) {
            assertEquals("[2, 1, NIL]", evaluated.toString())
            assertEquals(2, head)
            assertEquals(4, tail.head)
            assertEquals("[4, 3, 2, 1, NIL]", evaluated.toString())
            assertEquals("[2, 4, NIL]", toList().toString())
        }
    }

    @Test
    fun testFilter2() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream.filter { it % 2 != 0 }) {
            assertEquals("[1, NIL]", evaluated.toString())
            assertEquals(1, head)
            assertEquals(3, tail.head)
            assertEquals("[3, 2, 1, NIL]", evaluated.toString())
            assertEquals("[1, 3, 5, NIL]", toList().toString())
        }
    }

    @Test
    fun testFilterEmpty() {
        assertEquals("[NIL]", empty<Int>().filter { it % 2 != 0 }.toList().toString())
    }

    @Test
    fun testLongStreamFilter() {
        with(from(1).takeWhile { it < 500000 }.filter { it % 2 == 0 }) {
            assertEquals(2, head)
            assertEquals(4, tail.head)
            assertEquals(6, tail.tail.head)
        }
    }
}
