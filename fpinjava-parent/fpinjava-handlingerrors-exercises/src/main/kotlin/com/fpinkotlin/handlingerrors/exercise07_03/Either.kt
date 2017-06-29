package com.fpinkotlin.handlingerrors.exercise07_03

interface Either<E, A> {
	fun <B> map(f: (A) -> B): Either<E, B>
	fun <B> flatMap(f: (A) -> Either<E, B>): Either<E, B>
	fun getOrElse(defaultValue: () -> A): A

	fun orElse(defaultValue: () -> Either<E, A>): Either<E, A> =
			map { this }.getOrElse(defaultValue)
}

private class Left<E, A>(private val value: E) : Either<E, A> {

	override fun <B> map(f: (A) -> B): Either<E, B> = Left(value)

	override fun <B> flatMap(f: (A) -> Either<E, B>): Either<E, B> =
			Left(value)

	override fun getOrElse(defaultValue: () -> A): A = defaultValue()

	override fun toString(): String {
		return String.format("Left(%s)", value)
	}

}

private class Right<E, A>(private val value: A) : Either<E, A> {

	override fun <B> map(f: (A) -> B): Either<E, B> = Right(f(value))

	override fun <B> flatMap(f: (A) -> Either<E, B>): Either<E, B> =
			f(value)

	override fun getOrElse(defaultValue: () -> A): A = value

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
