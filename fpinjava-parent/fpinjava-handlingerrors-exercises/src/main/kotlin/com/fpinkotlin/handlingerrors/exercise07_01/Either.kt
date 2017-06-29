package com.fpinkotlin.handlingerrors.exercise07_01


interface Either<E, A> {
	fun <B> map(f: (A) -> B): Either<E, B>
}

private class Left<E, A>(private val value: E) : Either<E, A> {

	override fun <B> map(f: (A) -> B): Either<E, B> = Left(value)

	override fun toString(): String {
		return String.format("Left(%s)", value)
	}

}

private class Right<E, A>(private val value: A) : Either<E, A> {

	override fun <B> map(f: (A) -> B): Either<E, B> = Right(f(value))

	override fun toString(): String {
		return String.format("Right(%s)", value)
	}

}

fun <E, A> left(value: E): Either<E, A> {
	return Left(value)
}

fun <E, A> right(value: A): Either<E, A> {
	return Right(value)
}
