package com.fpinkotlin.lists.listing05_01

interface List<out A> {
	val empty: Boolean
	val head: A
	val tail: List<A>
}

object NIL : List<Any?> {
	override val empty: Boolean = true
	override val head: Any?
		get() = throw IllegalStateException("head called on empty list")

	override val tail: List<Any?>
		get() = throw IllegalStateException("tail called on empty list")

}

private class Cons<out A>(override val head: A,
                          override val tail: List<A>) : List<A> {
	override val empty: Boolean = false
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
