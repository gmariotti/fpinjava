package com.fpinkotlin.laziness.exercise09_01

import com.fpinkotlin.common.Result

interface Stream<A> {
	val head: A
	val tail: Stream<A>
	val isEmpty: Boolean

	fun headOption(): Result<A>
}

object Empty : Stream<Any?> {
	override val head: Any?
		get() = throw IllegalStateException("head called on empty")

	override val tail: Stream<Any?>
		get() = throw IllegalStateException("tail called on empty")

	override val isEmpty = true

	override fun headOption(): Result<Any?> = Result.empty()
}

private class Cons<A>(head: () -> A, tail: () -> Stream<A>) : Stream<A> {
	override val head: A by lazy(head)
	override val tail: Stream<A> by lazy(tail)
	override val isEmpty: Boolean = false

	override fun headOption(): Result<A> = Result.success(head)
}

@Suppress("UNCHECKED_CAST")
fun <A> empty(): Stream<A> = Empty as Stream<A>

fun <A> cons(head: () -> A, tail: () -> Stream<A>): Stream<A> = Cons(head, tail)

fun <A> cons(head: () -> A, tail: Stream<A>): Stream<A> = Cons(head, { tail })

fun from(i: Int): Stream<Int> = cons(head = { i }, tail = { from(i + 1) })