package com.fpinkotlin.optionaldata.exercise06_05

interface Option<A> {
	fun getOrThrow(): A
	fun getOrElse(defaultValue: () -> A): A
	fun <B> map(f: (A) -> B): Option<B>

	fun <B> flatMap(f: (A) -> Option<B>): Option<B> =
			this.map(f).getOrElse { none<B>() }

	fun orElse(f: () -> Option<A>): Option<A> =
			this.map { this }.getOrElse(f)
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