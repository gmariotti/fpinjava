package com.fpinkotlin.lists.exercise05_04

fun <A> list(): List<A> = object : List<A>() {
	override val empty: Boolean = true

	override val head: A
		get() = throw IllegalStateException("head called on empty list")

	override val tail: List<A>
		get() = throw IllegalStateException("tail called on empty list")

	override fun setHead(h: A): List<A> =
			throw IllegalStateException("setHead called on empty list")

	override fun drop(n: Int): List<A> = this

	override fun toString(): String = "[NIL]"
}

fun <A> list(vararg a: A): List<A> {
	var n = list<A>()
	for (e in a.reversed()) {
		n = Cons(e, n)
	}
	return n
}

fun <A> setHead(list: List<A>, h: A) = list.setHead(h)

abstract class List<A> {
	abstract val empty: Boolean
	abstract val head: A
	abstract val tail: List<A>

	abstract fun setHead(h: A): List<A>
	abstract fun drop(n: Int): List<A>

	fun cons(a: A): List<A> = Cons(a, this)
}

private class Cons<A>(override val head: A,
                      override val tail: List<A>) : List<A>() {
	override val empty: Boolean = false

	override fun setHead(h: A): List<A> = Cons(h, tail)

	override fun drop(n: Int): List<A> =
			if (n <= 0) this else drop_(this, n)

	private tailrec fun drop_(list: List<A>, n: Int): List<A> =
			if (n <= 0 || list.empty) list
			else drop_(list.tail, n - 1)

	override fun toString(): String =
			"[${toString_(this)}NIL]"

	private tailrec fun toString_(list: List<A>,
	                              builder: StringBuilder = StringBuilder()): StringBuilder =
			if (list.empty) builder
			else toString_(list.tail, builder.append("${list.head}, "))
}