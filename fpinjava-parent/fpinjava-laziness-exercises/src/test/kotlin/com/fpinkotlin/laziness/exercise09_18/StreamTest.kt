package com.fpinkotlin.laziness.exercise09_18

import com.fpinkotlin.common.Result
import org.junit.Assert.assertEquals
import org.junit.Test

class StreamTest {

    @Test
    fun testUnfold() {
        val stream = unfold(0 to 1) { Result.success(it.first to (it.second to (it.first + it.second))) }.take(25)
        assertEquals("[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, NIL]", stream.toList().toString())
    }
}
