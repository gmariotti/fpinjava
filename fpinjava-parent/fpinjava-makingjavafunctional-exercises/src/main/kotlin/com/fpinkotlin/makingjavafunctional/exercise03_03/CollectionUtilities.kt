package com.fpinkotlin.makingjavafunctional.exercise03_03

/**
 * Trivial because Kotlin already have "immutable" lists
 */

fun <T> list(): List<T> {
	return emptyList()
}

fun <T> list(t: T): List<T> {
	return listOf(t)
}

fun <T> list(ts: List<T>): List<T> {
	return ts.toList()
}

@SafeVarargs
fun <T> list(vararg t: T): List<T> {
	return listOf(*t)
}
