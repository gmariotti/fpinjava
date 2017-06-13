package com.fpinkotlin.lists.exercise05_07

import com.fpinkotlin.lists.exercise05_06.List

fun sum(ints: List<Int>): Int = if (ints.empty) 0 else ints.head + sum(ints.tail)