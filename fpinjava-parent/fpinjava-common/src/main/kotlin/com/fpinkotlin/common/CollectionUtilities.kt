package com.fpinkotlin.common

fun <T> List<T>.tail(): List<T> {
	if (this.isEmpty()) throw IllegalStateException("tail of empty list")
	return this.takeLast(this.size - 1)
}

fun <T> List<T>.append(t: T) = this + listOf(t)

fun <T, U> List<T>.foldLeft(identity: U, f: (U) -> (T) -> U): U {
	var result = identity
	for (t in this) {
		result = f(result)(t)
	}
	return result
}

fun <T, U> List<T>.foldRight(identity: U, f: (T) -> (U) -> (U)): U {
	return if (this.isEmpty()) identity else f(this.first())(this.tail().foldRight(identity, f))
}

fun <T, U> List<T>.map(f: (T) -> U): List<U> = this.mapViaFoldLeft(f)

fun <T, U> List<T>.mapViaFoldLeft(f: (T) -> U): List<U> =
		this.foldLeft(listOf()) { x -> { y -> x.append(f(y)) } }