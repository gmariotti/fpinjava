package com.fpinkotlin.laziness.exercise09_12

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

    private val stream1 = cons({ evaluate(1) },
        cons({ evaluate(2) },
            cons({ evaluate(3) },
                cons({ evaluate(4) },
                    cons({ evaluate(5) },
                        empty()))))
    )

    private val stream2 = cons({ evaluate(6) },
        cons({ evaluate(7) },
            cons({ evaluate(8) },
                cons({ evaluate(9) },
                    cons({ evaluate(10) },
                        empty()))))
    )

    @Test
    fun testAppend() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream1.append { stream2 }) {
            assertEquals("[1, NIL]", evaluated.toString())
            assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, NIL]", toList().toString())
        }
    }

    @Test
    fun testAppendEmpty() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream1.append { empty() }) {
            assertEquals("[1, NIL]", evaluated.toString())
            assertEquals("[1, 2, 3, 4, 5, NIL]", toList().toString())
        }
    }

    @Test
    fun testAppendEmpty2() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(empty<Int>().append { stream2 }) {
            assertEquals("[NIL]", evaluated.toString())
            assertEquals("[6, 7, 8, 9, 10, NIL]", toList().toString())
        }
    }

    @Test
    fun testLongStreamFilter() {
        val stream1 = from(0).takeWhile { x -> x < 250000 }
        val stream2 = from(250000).takeWhile { x -> x < 500000 }
        assertEquals(500000, stream1.append { stream2 }.toList().length().toLong())
    }
}
