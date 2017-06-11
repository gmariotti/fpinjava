package com.fpinkotlin.recursion.exercise04_05

import com.fpinkotlin.recursion.exercise04_03.tail

fun <T, U> foldRight(ts: List<T>, identity: U, f: (T) -> (U) -> (U)): U {
	return foldRight_(identity, ts.reversed(), f)
}

private tailrec fun <T, U> foldRight_(acc: U, ts: List<T>, f: (T) -> (U) -> (U)): U {
	if (ts.isEmpty()) {
		return acc
	} else {
		return foldRight_(f(ts.first())(acc), ts.tail(), f)
	}
}
