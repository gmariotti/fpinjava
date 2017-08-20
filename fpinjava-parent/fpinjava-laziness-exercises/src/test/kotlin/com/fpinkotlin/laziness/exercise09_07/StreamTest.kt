package com.fpinkotlin.laziness.exercise09_07

import com.fpinkotlin.common.Supplier
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
                        empty()))))
    )

    @Test
    fun testFoldRight() {
        val f: (Int) -> (Supplier<String>) -> String = { x -> { y -> "(" + x + " + " + y() + ")" } }
        assertEquals("(1 + (2 + (3 + (4 + (5 + 0)))))", stream.foldRight({ "0" }, f))
    }
}
