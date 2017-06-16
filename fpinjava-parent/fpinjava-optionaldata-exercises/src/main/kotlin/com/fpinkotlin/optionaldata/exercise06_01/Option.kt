package com.fpinkotlin.optionaldata.exercise06_01

interface Option<A> {
	fun getOrThrow(): A
	fun getOrElse(defaultValue: A): A
}

private object None : Option<Any?> {
	override fun getOrThrow(): Any? = throw IllegalStateException("getOrThrow called on None")

	override fun getOrElse(defaultValue: Any?) = defaultValue

	override fun toString(): String = "None"
}

private class Some<A>(val value: A) : Option<A> {
	override fun getOrThrow(): A = value

	override fun getOrElse(defaultValue: A): A = value

	override fun toString(): String = "Some($value)"
}

@Suppress("UNCHECKED_CAST")
fun <A> none(): Option<A> = None as Option<A>

fun <A> some(value: A): Option<A> = Some(value)