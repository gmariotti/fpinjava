package com.fpinkotlin.handlingerrors.exercise07_15

import com.fpinkotlin.handlingerrors.exercise07_15.Result.Companion.empty
import com.fpinkotlin.handlingerrors.exercise07_15.Result.Companion.failure
import com.fpinkotlin.handlingerrors.exercise07_15.Result.Companion.success
import java.io.Serializable

private val empty = Empty<Any?>()

interface Result<V> : Serializable {
	fun getOrElse(defaultValue: V): V
	fun getOrElse(defaultValue: () -> V): V
	fun <U> map(f: (V) -> U): Result<U>
	fun <U> flatMap(f: (V) -> Result<U>): Result<U>
	fun mapFailure(string: String): Result<V>
	fun mapFailure(string: String = "", e: Exception): Result<V>
	fun forEach(ef: (V) -> Unit): Unit
	fun forEachOrThrow(ef: (V) -> Unit): Unit
	fun forEachOrException(ef: (V) -> Unit): Result<RuntimeException>
	fun <U> foldLeft(identity: U, f: (U) -> (V) -> U): U
	fun <U> foldRight(identity: U, f: (V) -> (U) -> U): U

	fun orElse(defaultValue: () -> Result<V>): Result<V> = map { this }.getOrElse(defaultValue)

	fun filter(p: (V) -> Boolean, message: String = "Condition not matched"): Result<V> =
			flatMap { if (p(it)) this else failure(message) }

	fun exists(p: (V) -> Boolean): Boolean = map(p).getOrElse(false)

	companion object {
		fun <V> failure(message: String): Result<V> = Failure(message)

		fun <V> failure(e: RuntimeException): Result<V> = Failure(e)

		fun <V> failure(e: Exception): Result<V> = Failure(e)

		fun <V> success(value: V): Result<V> = Success(value)

		@Suppress("UNCHECKED_CAST")
		fun <V> empty(): Result<V> = empty as Result<V>

		fun <V> of(value: V?, message: String = ""): Result<V> =
				value?.let { success(it) } ?: if (message != "") failure(message) else empty()

		fun <V> of(value: V?, message: String = "%s", predicate: (V) -> Boolean): Result<V> {
			return try {
				when {
					value != null && predicate(value) -> success(value)
					message == "%s" -> empty()
					else -> failure(String.format(message, value))
				}
			} catch (e: Exception) {
				val errMessage = "Exception while evaluating predicate: ${String.format(message, value)}"
				failure(IllegalStateException(errMessage, e))
			}
		}

		fun <A, B> lift(f: (A) -> B): (Result<A>) -> Result<B> = {
			try {
				it.map(f)
			} catch (e: Exception) {
				failure(e)
			}
		}

		fun <A, B, C> lift2(f: (A) -> (B) -> C): (Result<A>) -> (Result<B>) -> Result<C> =
				{ a -> { b -> a.map(f).flatMap(b::map) } }

		fun <A, B, C, D> lift3(f: (A) -> (B) -> (C) -> D):
				(Result<A>) -> (Result<B>) -> (Result<C>) -> Result<D> = { a ->
			{ b -> { c -> a.map(f).flatMap(b::map).flatMap(c::map) } }
		}

		fun <A, B, C> map2(a: Result<A>, b: Result<B>, f: (A) -> (B) -> C): Result<C> =
				lift2(f)(a)(b)
	}
}

private open class Empty<V> : Result<V> {
	override fun getOrElse(defaultValue: V): V = defaultValue

	override fun getOrElse(defaultValue: () -> V): V = defaultValue()

	override fun <U> map(f: (V) -> U): Result<U> = empty()

	override fun <U> flatMap(f: (V) -> Result<U>): Result<U> = empty()

	override fun mapFailure(string: String): Result<V> = this

	override fun mapFailure(string: String, e: Exception): Result<V> = this

	override fun forEach(ef: (V) -> Unit) {}

	override fun forEachOrThrow(ef: (V) -> Unit) {}

	override fun forEachOrException(ef: (V) -> Unit): Result<RuntimeException> = empty()

	override fun <U> foldLeft(identity: U, f: (U) -> (V) -> U): U = identity

	override fun <U> foldRight(identity: U, f: (V) -> (U) -> U): U = identity

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

	override fun <U> map(f: (V) -> U): Result<U> = failure(exception)

	override fun <U> flatMap(f: (V) -> Result<U>): Result<U> = failure(exception)

	override fun mapFailure(string: String): Result<V> =
			failure(IllegalStateException(string, exception))

	override fun mapFailure(string: String, e: Exception): Result<V> =
			when (string) {
				"" -> failure(exception)
				else -> failure(IllegalStateException(string, exception))
			}

	override fun forEachOrThrow(ef: (V) -> Unit) = throw exception

	override fun forEachOrException(ef: (V) -> Unit): Result<RuntimeException> = success(exception)

	override fun toString(): String = "Failure(${exception.message})"

}

private data class Success<V>(val value: V) : Result<V> {

	override fun getOrElse(defaultValue: V): V = value

	override fun getOrElse(defaultValue: () -> V): V = value

	override fun <U> map(f: (V) -> U): Result<U> {
		try {
			return Result.success(f(value))
		} catch (e: Exception) {
			return failure(e)
		}
	}

	override fun <U> flatMap(f: (V) -> Result<U>): Result<U> {
		try {
			return f(value)
		} catch (e: Exception) {
			return failure(e)
		}
	}

	override fun mapFailure(string: String): Result<V> = this

	override fun mapFailure(string: String, e: Exception): Result<V> = this

	override fun forEach(ef: (V) -> Unit) = ef(value)

	override fun forEachOrThrow(ef: (V) -> Unit) = ef(value)

	override fun forEachOrException(ef: (V) -> Unit): Result<RuntimeException> {
		ef(value)
		return empty()
	}

	override fun <U> foldLeft(identity: U, f: (U) -> (V) -> U): U = f(identity)(value)

	override fun <U> foldRight(identity: U, f: (V) -> (U) -> U): U = f(value)(identity)

	override fun toString(): String = "Success($value)"

}
