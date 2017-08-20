package com.fpinkotlin.laziness.exercise09_08

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
    fun testTakeWhile() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(stream.takeWhile { x -> x < 3 }) {
            assertEquals("[1, NIL]", evaluated.toString())
            assertEquals("[1, 2, NIL]", toList().toString())
        }
    }

    @Test
    fun testTakeWhileEmpty() {
        assertEquals("[NIL]", empty<Int>().takeWhile { it < 4 }.toList().toString())
    }

    @Test
    fun testLongTakeWhileViaFoldRightTrue() {
        with(from(0)) {
            val result = takeWhile { it < 500000 }.drop(200000).take(5)
            assertEquals("[200000, 200001, 200002, 200003, 200004, NIL]", result.toList().toString())
        }
    }

    @Test
    fun testLongTakeWhileViaFoldRightFalse() {
        with(from(0)) {
            val result = takeWhile { it < 0 }.drop(200000).take(5)
            assertEquals("[NIL]", result.toList().toString())
        }
    }
}
