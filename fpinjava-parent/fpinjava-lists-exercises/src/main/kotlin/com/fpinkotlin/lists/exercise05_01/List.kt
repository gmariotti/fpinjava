package com.fpinkotlin.lists.exercise05_01

fun <A> list(): List<A> = object : List<A>() {
	override val empty: Boolean = true

	override val head: A
		get() =	throw IllegalStateException("head called on empty list")

	override val tail: List<A>
		get() =	throw IllegalStateException("tail called on empty list")
}

fun <A> list(vararg a: A): List<A> {
	var n = list<A>()
	for (e in a.reversed()) {
		n = Cons(e, n)
	}
	return n
}

abstract class List<A> {
	abstract val empty: Boolean
	abstract val head: A
	abstract val tail: List<A>

	fun cons(a: A): List<A> = Cons(a, this)
}

private class Cons<A>(override val head: A,
                      override val tail: List<A>) : List<A>() {
	override val empty: Boolean = false
}
