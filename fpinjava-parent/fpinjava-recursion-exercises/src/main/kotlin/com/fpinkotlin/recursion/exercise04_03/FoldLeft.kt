package com.fpinkotlin.recursion.exercise04_03

fun <T> List<T>.tail() = this.takeLast(this.size - 1)

tailrec fun <T, U> foldLeft(ts: List<T>, identity: U, f: (U) -> (T) -> (U)): U {
	if (ts.isEmpty()) {
		return identity
	} else {
		return foldLeft(ts.tail(), f(identity)(ts.first()), f)
	}
}
