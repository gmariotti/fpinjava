package com.fpinkotlin.common

fun <T> identity(): (T) -> T = { it }

fun <T, U, V> ((T) -> U).compose(f: (V) -> T): (V) -> U = { this(f(it)) }

fun <T, U, V> ((T) -> U).andThen(f: (U) -> V): (T) -> V = { f(this(it)) }
