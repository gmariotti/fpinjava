package com.fpinkotlin.makingjavafunctional.exercise03_12

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

fun <T, U> foldRight(ts: List<T>, identity: U, f: (T) -> (U) -> (U)): U =
		if (ts.isEmpty()) identity else f(head(ts))(foldRight(tail(ts), identity, f))

fun <T> append(list: List<T>, t: T): List<T> {
	val ts = list.toMutableList()
	ts.add(t)
	return ts.toList()
}

fun <T> prepend(t: T, list: List<T>): List<T> =
		foldLeft(list, list(t), { x -> { y -> append(x, y) } })

fun <T> reverse(list: List<T>): List<T> {
	return foldLeft(list, list<T>(), { x -> { y -> prepend(y, x) } })
}

fun <T, U> mapViaFoldLeft(list: List<T>, f: (T) -> (U)): List<U> =
		foldLeft(list, listOf(), { x -> { y -> append(x, f(y)) } })

fun <T, U> mapViaFoldRight(list: List<T>, f: (T) -> (U)): List<U> {
	return foldRight(list, list<U>(), { x -> { y -> prepend(f(x), y) } })
}

fun <T> unfold(seed: T, f: (T) -> (T), p: (T) -> (Boolean)): List<T> {
	var result: List<T> = listOf()
	var temp = seed
	while (p(temp)) {
		result = append(result, temp)
		temp = f(temp)
	}
	return result
}
