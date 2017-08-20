package com.fpinkotlin.laziness.exercise09_06

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
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
                        empty()))))
    )

    @Test
    fun testExistsTrue() {
        assertTrue(stream.exists { it > 2 })
        assertEquals("[3, 2, 1, NIL]", evaluated.toString())
    }

    @Test
    fun testExistsFalse() {
        assertFalse(stream.exists { it < 0 })
        assertEquals("[5, 4, 3, 2, 1, NIL]", evaluated.toString())
    }

    @Test
    fun testExistsEmpty() {
        assertFalse(empty<Int>().exists { it < 0 })
    }
}
