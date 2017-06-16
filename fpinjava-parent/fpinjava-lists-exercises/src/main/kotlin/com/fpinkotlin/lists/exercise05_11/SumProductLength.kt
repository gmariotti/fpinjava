package com.fpinkotlin.lists.exercise05_11

import com.fpinkotlin.lists.exercise05_10.List

fun sumViaFoldLeft(list: List<Int>): Int = list.foldLeft(0) { x -> { y -> x + y } }

fun productViaFoldLeft(list: List<Double>): Double = list.foldLeft(1.0) { x -> { y -> x * y } }

fun <A> lengthViaFoldLeft(list: List<A>): Int = list.foldLeft(0) { x -> { _ -> x + 1 } }
