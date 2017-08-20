package com.fpinkotlin.laziness.exercise09_16

import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

    @Test
    fun testFrom() {
        val stream = from(2)
        assertEquals(14, stream.take(4).toList().foldRight(0) { x -> { x + it } })
    }

    @Test
    fun testRepeat() {
        val stream = repeat(2)
        assertEquals(8, stream.take(4).toList().foldRight(0) { x -> { x + it } })
    }
}
