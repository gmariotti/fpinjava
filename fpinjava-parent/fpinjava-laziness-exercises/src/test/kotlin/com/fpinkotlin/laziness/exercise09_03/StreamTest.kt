package com.fpinkotlin.laziness.exercise09_03

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
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
                        cons({ evaluate(5) },
                            empty()))))
        )

    @Test
    fun testTake() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        val result = stream.take(3)
        assertEquals("[NIL]", evaluated.toString())
        assertEquals("[1, 2, 3, NIL]", result.toList().toString())
    }

    @Test
    fun testTakeMore() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        val result = stream.take(3)
        assertEquals("[NIL]", evaluated.toString())
        assertEquals("[1, 2, 3, NIL]", result.toList().toString())
    }

    @Test
    fun testTakeEmpty() {
        assertEquals("[NIL]", empty<Any>().take(3).toList().toString())
    }

    @Test
    fun testDrop() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        val result = stream.drop(3)
        assertEquals("[NIL]", evaluated.toString())
        assertEquals("[4, 5, NIL]", result.toList().toString())
    }

    @Test
    fun testDropEmpty() {
        assertEquals("[NIL]", empty<Any>().drop(3).toList().toString())
    }

    @Test
    fun testTakeFromLongStream() {
        val stream = from(0)
        val result = stream.take(100000)
        val list = result.toList()
        assertEquals(100000, list.length().toLong())
        assertTrue(list.toString().startsWith("[0, 1, 2, 3, 4, 5"))
    }

    @Test
    fun testDropFromLongStream() {
        val stream = from(0)
        val result = stream.drop(100000)
        assertEquals(100000, result.head)
    }
}
