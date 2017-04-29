package com.fpinkotlin.makingjavafunctional.exercise03_01

sealed class Result<T> {

	abstract fun bind(success: (T) -> Unit, failure: (String) -> Unit)

	companion object {

		fun <T> failure(message: String): Result<T> = Failure(message)

		fun <T> success(value: T): Result<T> = Success(value)
	}

	private class Success<T> internal constructor(val value: T) : Result<T>() {
		override fun bind(success: (T) -> Unit, failure: (String) -> Unit) = success(value)
	}

	private class Failure<T> internal constructor(val errorMessage: String) : Result<T>() {
		override fun bind(success: (T) -> Unit, failure: (String) -> Unit) = failure(errorMessage)
	}

}
