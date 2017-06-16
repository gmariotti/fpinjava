package com.fpinkotlin.optionaldata.exercise06_12

import com.fpinkotlin.common.List
import com.fpinkotlin.common.list

interface Option<A> {
	fun getOrThrow(): A
	fun getOrElse(defaultValue: () -> A): A
	fun <B> map(f: (A) -> B): Option<B>

	fun <B> flatMap(f: (A) -> Option<B>): Option<B> =
			this.map(f).getOrElse { none<B>() }

	fun orElse(f: () -> Option<A>): Option<A> =
			this.map { this }.getOrElse(f)

	fun filter(p: (A) -> Boolean): Option<A> =
			this.flatMap { if (p(it)) this else none<A>() }
}

private object None : Option<Any?> {
	override fun getOrThrow(): Any? = throw IllegalStateException("getOrThrow called on None")

	override fun getOrElse(defaultValue: () -> Any?) = defaultValue()

	override fun <B> map(f: (Any?) -> B): Option<B> = none()

	override fun toString(): String = "None"
}

private class Some<A>(val value: A) : Option<A> {
	override fun getOrThrow(): A = value

	override fun getOrElse(defaultValue: () -> A): A = value

	override fun <B> map(f: (A) -> B): Option<B> = some(f(value))

	override fun toString(): String = "Some($value)"
}

@Suppress("UNCHECKED_CAST")
fun <A> none(): Option<A> = None as Option<A>

fun <A> some(value: A): Option<A> = Some(value)

fun <A, B> lift(f: (A) -> B): (Option<A>) -> Option<B> = {
	try {
		it.map(f)
	} catch (e: Exception) {
		none<B>()
	}
}

fun <A, B> hlift(f: (A) -> B): (A) -> Option<B> = {
	try {
		some(it).map(f)
	} catch (e: Exception) {
		none<B>()
	}
}

fun <A, B, C> map2(a: Option<A>, b: Option<B>, f: (A) -> (B) -> C): Option<C> =
		a.flatMap { ax -> b.map { bx -> f(ax)(bx) } }

fun <A, B, C, D> map3(a: Option<A>, b: Option<B>, c: Option<C>, f: (A) -> (B) -> (C) -> D): Option<D> =
		a.flatMap { ax -> b.flatMap { bx -> c.map { cx -> f(ax)(bx)(cx) } } }

fun <A, B> traverse(list: List<A>, f: (A) -> Option<B>): Option<List<B>> =
		list.foldRight(some(list<B>())) { x -> { y -> map2(f(x), y) { a: B -> { b: List<B> -> b.cons(a) } } } }

fun <A> sequence(list: List<Option<A>>): Option<List<A>> = traverse(list) { it }