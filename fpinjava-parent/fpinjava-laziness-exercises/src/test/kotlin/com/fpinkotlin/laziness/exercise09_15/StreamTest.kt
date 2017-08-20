package com.fpinkotlin.laziness.exercise09_15

import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

    @Test
    fun testRepeat() {
        val stream = repeat(2)
        assertEquals(8, stream.take(4).toList().foldRight(0) { x -> { x + it } })
    }
}
