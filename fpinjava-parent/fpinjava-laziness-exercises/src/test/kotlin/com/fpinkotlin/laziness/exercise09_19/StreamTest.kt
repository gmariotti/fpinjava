package com.fpinkotlin.laziness.exercise09_19

import com.fpinkotlin.common.List
import com.fpinkotlin.common.Result
import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

    private lateinit var evaluated: List<Int>

    private fun evaluate(n: Int): Int {
        evaluated = evaluated.cons(n)
        return n
    }

    @Test
    fun testFilter() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(getStream(1, 5).filter { it % 2 == 0 }) {
            assertEquals("[2, 1, NIL]", evaluated.toString())
            assertEquals(2, head)
            assertEquals(4, tail.head)
            assertEquals("[4, 3, 2, 1, NIL]", evaluated.toString())
            assertEquals("[2, 4, NIL]", toList().toString())
        }
    }

    @Test
    fun testFilter3() {
        evaluated = list()
        assertEquals("[NIL]", evaluated.toString())
        with(getStream(1, 6).filter { it % 2 != 0 }) {
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
        val stream = from(1).takeWhile { it < 500000 }
        val min = 2000
        with(stream.filter { it > min }) {
            assertEquals(min + 1, head)
            assertEquals(min + 2, tail.head)
            assertEquals(min + 3, tail.tail.head)
        }
    }

    @Test
    fun testLongFilter() {
        val result = from(0).filter { it > 200000 }.take(5)
        assertEquals("[200001, 200002, 200003, 200004, 200005, NIL]", result.toList().toString())
    }

    @Test
    fun testLongFilterEval1() {
        evaluated = list()
        with(getStream(1, 20).filter { it > 10 }) {
            assertEquals("[11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, NIL]", evaluated.toString())
            assertEquals("[11, 12, 13, 14, 15, 16, 17, 18, 19, NIL]", toList().toString())
        }
    }

    @Test
    fun testFrom() {
        evaluated = list()
        with(from { evaluate(1) }.take(2)) {
            assertEquals("[NIL]", evaluated.toString())
            assertEquals("[1, 2, NIL]", toList().toString())
        }
    }

    private fun getStream(start: Int, end: Int): Stream<Int> = unfold(start - 1) { e: Int ->
        with(evaluate(e + 1)) {
            if (this < end) Result.success(this to this) else Result.empty()
        }
    }

    private fun from(f: () -> Int): Stream<Int> = cons(head = f, tail = { from { evaluate(f() + 1) } })
}
