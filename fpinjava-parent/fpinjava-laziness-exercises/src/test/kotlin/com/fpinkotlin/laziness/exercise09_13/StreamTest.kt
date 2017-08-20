package com.fpinkotlin.laziness.exercise09_13

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
        with(stream.flatMap { from(it).take(it) }) {
            assertEquals(1, head)
            assertEquals(2, tail.head)
            assertEquals(3, tail.tail.head)
            assertEquals("[2, 1, NIL]", evaluated.toString())
            assertEquals("[1, 2, 3, 3, 4, 5, 4, 5, 6, 7, 5, 6, 7, 8, 9, NIL]", toList().toString())
        }
    }

    @Test
    fun testMapEmpty() {
        assertEquals("[NIL]", empty<Int>().flatMap { from(it).take(it) }.toList().toString())
    }

    @Test
    fun testLongStreamMap() {
        val stream = from(1).takeWhile { x -> x < 50000 }
        with(stream.flatMap { from(it).take(3) }) {
            assertEquals(1, head)
            assertEquals(2, drop(3).head)
            assertEquals(3, drop(6).head)
        }
    }
}
