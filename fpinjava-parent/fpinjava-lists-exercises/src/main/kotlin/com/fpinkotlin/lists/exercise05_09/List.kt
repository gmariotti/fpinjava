package com.fpinkotlin.lists.exercise05_09

fun <A> list(): List<A> = object : List<A>() {
	override val empty: Boolean = true

	override val head: A
		get() = throw IllegalStateException("head called on empty list")

	override val tail: List<A>
		get() = throw IllegalStateException("tail called on empty list")

	override fun setHead(h: A): List<A> =
			throw IllegalStateException("setHead called on empty list")

	override fun drop(n: Int): List<A> = this
	override fun dropWhile(f: (A) -> Boolean): List<A> = this
	override fun init(): List<A> = throw IllegalStateException("init called on empty list")
	override fun length(): Int = 0

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

fun <A, B> foldRight(list: List<A>, n: B, f: (A) -> (B) -> B): B =
		if (list.empty) n else f(list.head)(foldRight(list.tail, n, f))

abstract class List<A> {
	abstract val empty: Boolean
	abstract val head: A
	abstract val tail: List<A>

	abstract fun setHead(h: A): List<A>
	abstract fun drop(n: Int): List<A>
	abstract fun dropWhile(f: (A) -> Boolean): List<A>
	abstract fun init(): List<A>
	abstract fun length(): Int

	fun cons(a: A): List<A> = Cons(a, this)

	fun reverse(): List<A> = reverse_(list<A>(), this)
	private tailrec fun reverse_(acc: List<A>, list: List<A>): List<A> =
			if (list.empty) acc
			else reverse_(Cons(list.head, acc), list.tail)
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

	override fun dropWhile(f: (A) -> Boolean): List<A> = dropWhile_(this, f)

	private tailrec fun dropWhile_(list: List<A>, f: (A) -> Boolean): List<A> =
			if (!list.empty && f(list.head)) dropWhile_(list.tail, f)
			else list

	override fun init(): List<A> = this.reverse().tail.reverse()

	override fun length(): Int = foldRight(this, 0) { _ -> { y -> y + 1 } }

	override fun toString(): String =
			"[${toString_(this)}NIL]"

	private tailrec fun toString_(list: List<A>,
	                              builder: StringBuilder = StringBuilder()): StringBuilder =
			if (list.empty) builder
			else toString_(list.tail, builder.append("${list.head}, "))
}