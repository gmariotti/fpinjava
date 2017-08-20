package com.fpinkotlin.laziness.exercise09_01

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

    /**
     * The following tests verify that no elements are evaluated by the methods.
     * Only the elements that are in the streams when converting to list are
     * evaluated.
     */
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
                        cons({ evaluate(5) },
                            { empty() }))))
        )

    @Test
    fun testHeadOption() {
        evaluated = list()
        assertEquals("Success(1)", stream.headOption().toString())
        assertEquals("[1, NIL]", evaluated.toString())
    }

    @Test
    fun testHeadOptionEmpty() {
        val stream: Stream<Any> = empty()
        assertEquals("Empty()", stream.headOption().toString())
    }
}
