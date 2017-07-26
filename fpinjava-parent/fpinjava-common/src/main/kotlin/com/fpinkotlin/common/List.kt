package com.fpinkotlin.common

interface List<out A> {
	val empty: Boolean
	val head: A
	val tail: List<A>

	fun setHead(h: @UnsafeVariance A): List<A>
	fun drop(n: Int): List<A>
	fun dropWhile(f: (A) -> Boolean): List<A>
	fun init(): List<A>
	fun length(): Int
	fun <B> foldLeft(identity: B, f: (B) -> (A) -> B): B
	fun <B> foldRight(identity: B, f: (A) -> (B) -> B): B

	fun cons(a: @UnsafeVariance A): List<A> = Cons(a, this)

	fun reverse(): List<A> = reverse_(list<A>(), this)

	tailrec fun reverse_(acc: List<@UnsafeVariance A>, list: List<@UnsafeVariance A>): List<A> =
			if (list.empty) acc
			else reverse_(Cons(list.head, acc), list.tail)

	fun <B> map(f: (A) -> B): List<B> =
			this.foldRight(list<B>()) { head -> { tail -> tail.cons(f(head)) } }

	fun filter(f: (A) -> Boolean): List<A> =
			this.foldRight(list<A>()) { head -> { tail -> if (f(head)) tail.cons(head) else tail } }

	fun <B> flatMap(f: (A) -> List<B>): List<B> =
			this.foldRight(list<B>()) { head -> { tail -> concat(f(head), tail) } }
}

object NIL : List<Any?> {
	override val empty: Boolean = true
	override val head: Any?
		get() = throw IllegalStateException("head called on empty list")

	override val tail: List<Any?>
		get() = throw IllegalStateException("tail called on empty list")

	override fun setHead(h: Any?): List<Any?> =
			throw IllegalStateException("setHead called on empty list")

	override fun drop(n: Int): List<Any?> = this

	override fun dropWhile(f: (Any?) -> Boolean): List<Any?> = this

	override fun init(): List<Any?> = throw IllegalStateException("init called on empty list")

	override fun length(): Int = 0

	override fun <B> foldLeft(identity: B, f: (B) -> (Any?) -> B): B = identity

	override fun <B> foldRight(identity: B, f: (Any?) -> (B) -> B): B = identity

	override fun toString(): String = "[NIL]"
}

private class Cons<A>(override val head: A,
                      override val tail: List<A>) : List<A> {
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

	override fun length(): Int = this.foldRight(0) { _ -> { y -> y + 1 } }

	override fun <B> foldLeft(identity: B, f: (B) -> (A) -> B): B = foldLeft_(identity, this, f)

	private tailrec fun <B> foldLeft_(acc: B, list: List<A>, f: (B) -> (A) -> B): B =
			if (list.empty) acc
			else foldLeft_(f(acc)(list.head), list.tail, f)

	override fun <B> foldRight(identity: B, f: (A) -> (B) -> B): B =
			foldRight_(identity, this.reverse(), f)

	private tailrec fun <B> foldRight_(acc: B, list: List<A>, f: (A) -> (B) -> B): B =
			if (list.empty) acc
			else foldRight_(f(list.head)(acc), list.tail, f)

	override fun toString(): String =
			"[${toString_(this)}NIL]"

	private tailrec fun toString_(list: List<A>,
	                              builder: StringBuilder = StringBuilder()): StringBuilder =
			if (list.empty) builder
			else toString_(list.tail, builder.append("${list.head}, "))
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

fun <A> setHead(list: List<A>, h: A) = list.setHead(h)

fun <A, B> foldRight(list: List<A>, n: B, f: (A) -> (B) -> B): B =
		if (list.empty) n else f(list.head)(foldRight(list.tail, n, f))

fun <A> concat(list1: List<A>, list2: List<A>): List<A> =
		list1.foldRight(list2) { a -> { list -> list.cons(a) } }

fun <A> flatten(list: List<List<A>>): List<A> =
		list.foldRight(list<A>()) { x -> { y -> concat(x, y) } }