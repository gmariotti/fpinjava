package com.fpinkotlin.lists.exercise05_03

import com.fpinkotlin.common.TailCall
import com.fpinkotlin.common.TailCall.Companion.ret
import com.fpinkotlin.common.TailCall.Companion.sus
import javax.lang.model.util.ElementScanner6

fun <A> list(): List<A> = object : List<A>() {
	override val empty: Boolean = true

	override val head: A
		get() = throw IllegalStateException("head called on empty list")

	override val tail: List<A>
		get() = throw IllegalStateException("tail called on empty list")

	override fun setHead(h: A): List<A> =
			throw IllegalStateException("setHead called on empty list")

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

	fun cons(a: A): List<A> = Cons(a, this)
}

private class Cons<A>(override val head: A,
                      override val tail: List<A>) : List<A>() {
	override val empty: Boolean = false

	override fun setHead(h: A): List<A> = Cons(h, tail)

	override fun toString(): String =
			"[${toString_(this)()}NIL]"

	private fun toString_(list: List<A>,
	                      builder: StringBuilder = StringBuilder()): TailCall<StringBuilder> =
			if (list.empty) ret(builder)
			else sus { toString_(list.tail, builder.append("${list.head}, ")) }
}