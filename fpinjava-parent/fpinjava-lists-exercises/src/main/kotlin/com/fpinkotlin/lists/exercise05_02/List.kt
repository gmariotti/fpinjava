package com.fpinkotlin.lists.exercise05_02

interface List<out A> {
	val empty: Boolean
	val head: A
	val tail: List<A>

	fun setHead(h: @UnsafeVariance A): List<A>

	fun cons(a: @UnsafeVariance A): List<A> = Cons(a, this)
}

object NIL : List<Any?> {
	override val empty: Boolean = true
	override val head: Any?
		get() = throw IllegalStateException("head called on empty list")

	override val tail: List<Any?>
		get() = throw IllegalStateException("tail called on empty list")

	override fun setHead(h: Any?): List<Any?> =
			throw IllegalStateException("setHead called on empty list")
}

private class Cons<A>(override val head: A,
                      override val tail: List<A>) : List<A> {
	override val empty: Boolean = false

	override fun setHead(h: A): List<A> = Cons(h, tail)
}

@Suppress("UNCHECKED_CAST")
fun <A> list(): List<A> = NIL as List<A>

fun <A> list(vararg a: A): List<A> {
	var n = list<A>()
	for (e in a.reversed()) {
		n = Cons(e, n)
	}
	return n
}
