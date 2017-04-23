package com.fpinkotlin.functions.exercise02_01;

val triple: (Int) -> (Int) = { it * 3 }

val square: (Int) -> (Int) = { it * it }

infix fun ((Int) -> (Int)).compose(f1: (Int) -> Int): (Int) -> (Int) = { this(f1(it)) }