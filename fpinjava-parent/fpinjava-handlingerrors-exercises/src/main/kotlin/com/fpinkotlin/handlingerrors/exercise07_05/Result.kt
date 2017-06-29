package com.fpinkotlin.handlingerrors.exercise07_05

import java.io.Serializable

private val empty = Empty<Any?>()

interface Result<V> : Serializable {
	fun getOrElse(defaultValue: V): V
	fun getOrElse(defaultValue: () -> V): V
	fun <U> map(f: (V) -> U): Result<U>
	fun <U> flatMap(f: (V) -> Result<U>): Result<U>

	fun orElse(defaultValue: () -> Result<V>): Result<V> = map { this }.getOrElse(defaultValue)

	fun filter(p: (V) -> Boolean, message: String = "Condition not matched"): Result<V> =
			flatMap { if (p(it)) this else failure(message) }

	companion object {
		fun <V> failure(message: String): Result<V> = Failure(message)

		fun <V> failure(e: RuntimeException): Result<V> = Failure(e)

		fun <V> failure(e: Exception): Result<V> = Failure(e)

		fun <V> success(value: V): Result<V> = Success(value)

		@Suppress("UNCHECKED_CAST")
		fun <V> empty(): Result<V> = empty as Result<V>
	}
}

private open class Empty<V> : Result<V> {
	override fun getOrElse(defaultValue: V): V = defaultValue

	override fun getOrElse(defaultValue: () -> V): V = defaultValue()

	override fun <U> map(f: (V) -> U): Result<U> = Result.empty()

	override fun <U> flatMap(f: (V) -> Result<U>): Result<U> = Result.empty()

	override fun toString(): String = "Empty()"
}

private class Failure<V> : Empty<V> {

	val exception: RuntimeException

	constructor(message: String) : super() {
		this.exception = IllegalStateException(message)
	}

	constructor(e: RuntimeException) : super() {
		this.exception = e
	}

	constructor(e: Exception) : super() {
		this.exception = IllegalStateException(e)
	}

	override fun <U> map(f: (V) -> U): Result<U> = Result.failure(exception)

	override fun <U> flatMap(f: (V) -> Result<U>): Result<U> = Result.failure(exception)

	override fun toString(): String = "Failure(${exception.message})"

}

private class Success<V>(val value: V) : Result<V> {

	override fun getOrElse(defaultValue: V): V = value

	override fun getOrElse(defaultValue: () -> V): V = value

	override fun <U> map(f: (V) -> U): Result<U> {
		try {
			return Result.success(f(value))
		} catch (e: Exception) {
			return Result.failure(e)
		}
	}

	override fun <U> flatMap(f: (V) -> Result<U>): Result<U> {
		try {
			return f(value)
		} catch (e: Exception) {
			return Result.failure(e)
		}
	}

	override fun toString(): String = "Success($value)"

}
