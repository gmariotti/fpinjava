package com.fpinkotlin.common

abstract class TailCall<T> private constructor() {

	abstract val isSuspend: Boolean
	abstract operator fun invoke(): T
	abstract fun resume(): TailCall<T>

	private class Return<T> (val t: T) : TailCall<T>() {
		override val isSuspend: Boolean = false

		override operator fun invoke(): T = t

		override fun resume(): TailCall<T> = throw IllegalStateException("Return has no resume")
	}

	private class Suspend<T> (val resume: () -> TailCall<T>) : TailCall<T>() {
		override val isSuspend: Boolean = true

		override operator fun invoke(): T {
			var tailRec: TailCall<T> = this
			while (tailRec.isSuspend) {
				tailRec = tailRec.resume()
			}
			return tailRec()
		}

		override fun resume(): TailCall<T> = resume.invoke()
	}

	companion object {

		fun <T> ret(t: T): TailCall<T> {
			return Return(t)
		}

		fun <T> sus(s: () -> TailCall<T>): TailCall<T> {
			return Suspend(s)
		}
	}
}
