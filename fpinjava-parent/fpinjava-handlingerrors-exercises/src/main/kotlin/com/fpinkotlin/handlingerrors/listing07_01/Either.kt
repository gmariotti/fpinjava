package com.fpinkotlin.handlingerrors.listing07_01


interface Either<T, U>

private class Left<T, U>(private val value: T) : Either<T, U> {

	override fun toString(): String {
		return String.format("Left(%s)", value)
	}

}

private class Right<T, U>(private val value: U) : Either<T, U> {

	override fun toString(): String {
		return String.format("Right(%s)", value)
	}

}

fun <T, U> left(value: T): Either<T, U> {
	return Left(value)
}

fun <T, U> right(value: U): Either<T, U> {
	return Right(value)
}
