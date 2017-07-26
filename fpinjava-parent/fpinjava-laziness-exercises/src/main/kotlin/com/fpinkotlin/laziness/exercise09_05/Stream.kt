package com.fpinkotlin.laziness.exercise09_05

import com.fpinkotlin.common.List
import com.fpinkotlin.common.Result
import com.fpinkotlin.common.list

interface Stream<A> {
	val head: A
	val tail: Stream<A>
	val isEmpty: Boolean

	fun headOption(): Result<A>
	fun take(n: Int): Stream<A>
	fun drop(n: Int): Stream<A>
	fun takeWhile(f: (A) -> Boolean): Stream<A>

	fun dropWhile(f: (A) -> Boolean): Stream<A> = dropWhile_(this, f)

	private tailrec fun dropWhile_(acc: Stream<A>, f: (A) -> Boolean): Stream<A> =
			when {
				isEmpty -> acc
				f(acc.head) -> dropWhile_(acc.tail, f)
				else -> acc
			}

	fun toList(): List<A> = toList_(this, list()).reverse()

	private tailrec fun toList_(stream: Stream<A>, acc: List<A>): List<A> =
			if (stream.isEmpty) acc
			else toList_(stream.tail, acc.cons(stream.head))
}

object Empty : Stream<Any?> {
	override val head: Any?
		get() = throw IllegalStateException("head called on empty")

	override val tail: Stream<Any?>
		get() = throw IllegalStateException("tail called on empty")

	override val isEmpty = true

	override fun headOption(): Result<Any?> = Result.empty()

	override fun take(n: Int): Stream<Any?> = this

	override fun drop(n: Int): Stream<Any?> = this

	override fun takeWhile(f: (Any?) -> Boolean): Stream<Any?> = this
}

private class Cons<A>(head: () -> A, tail: () -> Stream<A>) : Stream<A> {
	override val head: A by lazy(head)
	override val tail: Stream<A> by lazy(tail)
	override val isEmpty: Boolean = false

	override fun headOption(): Result<A> = Result.success(head)

	override fun take(n: Int): Stream<A> =
			if (n <= 0) empty()
			else cons({ head }, { tail.take(n - 1) })

	override fun drop(n: Int): Stream<A> = drop_(this, n)

	private tailrec fun drop_(acc: Stream<A>, n: Int): Stream<A> =
			if (n <= 0) acc
			else drop_(acc.tail, n - 1)

	override fun takeWhile(f: (A) -> Boolean): Stream<A> =
			if (f(head)) cons({ head }, { tail.takeWhile(f) })
			else empty()
}

@Suppress("UNCHECKED_CAST")
fun <A> empty(): Stream<A> = Empty as Stream<A>

fun <A> cons(head: () -> A, tail: () -> Stream<A>): Stream<A> = Cons(head, tail)

fun <A> cons(head: () -> A, tail: Stream<A>): Stream<A> = Cons(head, { tail })

fun from(i: Int): Stream<Int> = cons(head = { i }, tail = { from(i + 1) })