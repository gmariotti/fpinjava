package com.fpinkotlin.laziness.exercise09_09

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

    private var evaluated = list<Int>()

    private fun evaluate(n: Int): Int {
        evaluated = evaluated.cons(n)
        return n
    }

    private val stream = cons({ evaluate(1) },
        cons({ evaluate(2) },
            cons({ evaluate(3) },
                cons({ evaluate(4) },
                    cons({ evaluate(5) },
                        { empty() }))))
    )

    @Test
    fun testHeadOption() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        assertEquals("Success(1)", stream.headOptionViaFoldRight().toString())
        assertEquals("[1, NIL]", evaluated.toString())
    }

    @Test
    fun testHeadOptionEmpty() {
        assertEquals("Empty()", empty<Any>().headOptionViaFoldRight().toString())
    }

    @Test
    fun testLongStreamFalse() {
        with(from(0).take(500000)) {
            assertEquals("Success(0)", headOptionViaFoldRight().toString())
        }
    }
}
