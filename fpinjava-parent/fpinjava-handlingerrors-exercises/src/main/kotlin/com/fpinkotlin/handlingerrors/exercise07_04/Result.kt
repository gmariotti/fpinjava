package com.fpinkotlin.handlingerrors.exercise07_04

import java.io.Serializable

interface Result<V> : Serializable {
	fun getOrElse(defaultValue: V): V
	fun getOrElse(defaultValue: () -> V): V
	fun <U> map(f: (V) -> U): Result<U>
	fun <U> flatMap(f: (V) -> Result<U>): Result<U>

	fun orElse(defaultValue: () -> Result<V>): Result<V> = map { this }.getOrElse(defaultValue)
}

private class Failure<V> : Result<V> {
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

	override fun getOrElse(defaultValue: V): V = defaultValue

	override fun getOrElse(defaultValue: () -> V): V = defaultValue()

	override fun <U> map(f: (V) -> U): Result<U> = failure(exception)

	override fun <U> flatMap(f: (V) -> Result<U>): Result<U> = failure(exception)

	override fun toString(): String {
		return String.format("Failure(%s)", exception.message)
	}
}

private data class Success<V>(val value: V) : Result<V> {
	override fun getOrElse(defaultValue: V): V = value

	override fun getOrElse(defaultValue: () -> V): V = value

	override fun <U> map(f: (V) -> U): Result<U> {
		try {
			return success(f(value))
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

	override fun toString(): String {
		return String.format("Success(%s)", value.toString())
	}
}

fun <V> failure(message: String): Result<V> = Failure(message)

fun <V> failure(e: RuntimeException): Result<V> = Failure(e)

fun <V> failure(e: Exception): Result<V> = Failure(e)

fun <V> success(value: V): Result<V> = Success(value)
