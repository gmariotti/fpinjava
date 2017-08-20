package com.fpinkotlin.laziness.exercise09_13

import com.fpinkotlin.common.list

private fun evaluate(n: Int): Int {
    return n
}

private val stream = cons({ evaluate(1) },
    cons({ evaluate(2) },
        cons({ evaluate(3) },
            cons({ evaluate(4) },
                cons({ evaluate(5) },
                    empty()))))
)

private val f: (Int) -> Int = {
    println("Mapping f " + it)
    it * 3
}

private val p: (Int) -> Boolean = {
    println("Filtering " + it)
    it % 2 == 0
}

fun main(args: Array<String>) {
    println("==List==")
    val list = list(1, 2, 3, 4, 5).map(f).filter(p)
    println(list)
    println("==Stream==")
    val result = stream.map(f).filter(p)
    println(result.toList())
}
