package com.fpinkotlin.laziness.exercise09_17

import org.junit.Test

import org.junit.Assert.assertEquals

class StreamTest {

    @Test
    fun testFibs() {
        val stream = fibs().take(25)
        assertEquals("[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, NIL]", stream.toList().toString())
    }
}
