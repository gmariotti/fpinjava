package com.fpinkotlin.handlingerrors.listing07_02

import java.io.Serializable

interface Result<V> : Serializable

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

	override fun toString(): String {
		return String.format("Failure(%s)", exception.message)
	}
}

private class Success<V>(val value: V) : Result<V> {

	override fun toString(): String {
		return String.format("Success(%s)", value.toString())
	}
}

fun <V> failure(message: String): Result<V> = Failure(message)

fun <V> failure(e: RuntimeException): Result<V> = Failure(e)

fun <V> failure(e: Exception): Result<V> = Failure(e)

fun <V> success(value: V): Result<V> = Success(value)
