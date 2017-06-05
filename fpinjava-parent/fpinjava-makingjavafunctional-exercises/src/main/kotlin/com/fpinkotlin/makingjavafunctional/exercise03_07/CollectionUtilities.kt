package com.fpinkotlin.makingjavafunctional.exercise03_07

fun <T> list(): List<T> = emptyList()

fun <T> list(t: T): List<T> = listOf(t)

fun <T> list(ts: List<T>): List<T> = ts.takeLast(ts.size)

fun <T> list(vararg t: T): List<T> = listOf(*t)

fun <T> head(list: List<T>): T = list.first()

fun <T> copy(ts: List<T>): List<T> = list(ts)

fun <T> tail(list: List<T>): List<T> {
	if (list.isEmpty()) {
		throw IllegalStateException()
	}
	return list.takeLast(list.size - 1)
}

fun <T, U> foldLeft(ts: List<T>, identity: U, f: (U) -> (T) -> (U)): U {
	var result = identity
	for (t in ts) {
		result = f(result)(t)
	}
	return result
}

fun <T, U> foldRight(ts: List<T>, identity: U, f: (T) -> (U) -> (U)): U {
	var result = identity
	for (i in ts.reversed()) {
		result = f(i)(result)
	}
	return result
}

fun <T> append(list: List<T>, t: T): List<T> {
	val ts = list.toMutableList()
	ts.add(t)
	return ts.toList()
}
