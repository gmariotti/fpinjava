package com.fpinkotlin.laziness.exercise09_14

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
    fun testFindTrue() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream.find { it > 3 }) {
            assertEquals("[4, 3, 2, 1, NIL]", evaluated.toString())
            assertEquals("Success(4)", toString())
        }
    }

    @Test
    fun testFindFalse() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream.find { it < 0 }) {
            assertEquals("[5, 4, 3, 2, 1, NIL]", evaluated.toString())
            assertEquals("Empty()", toString())
        }
    }

    @Test
    fun testFilterEmpty() {
        assertEquals("Empty()", empty<Int>().find { it > 3 }.toString())
    }

    @Test
    fun testLongStreamFilter() {
        with(from(1).takeWhile { it < 500000 }) {
            val result = find { it % 17 == 0 && it > 100 }
            assertEquals("Success(102)", result.toString())
        }
    }
}
