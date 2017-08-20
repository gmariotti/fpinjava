package com.fpinkotlin.laziness.exercise09_14

import com.fpinkotlin.common.List
import com.fpinkotlin.common.Result
import com.fpinkotlin.common.Supplier
import com.fpinkotlin.common.list

interface Stream<A> {
    val head: A
    val tail: Stream<A>
    val isEmpty: Boolean

    fun headOption(): Result<A>
    fun take(n: Int): Stream<A>
    fun drop(n: Int): Stream<A>
    fun takeWhile_(f: (A) -> Boolean): Stream<A>
    fun <B> foldRight(z: () -> B, f: (A) -> (Supplier<B>) -> B): B

    fun dropWhile(f: (A) -> Boolean): Stream<A> = dropWhile_(this, f)

    private tailrec fun dropWhile_(acc: Stream<A>, f: (A) -> Boolean): Stream<A> =
        when {
            isEmpty -> acc
            f(acc.head) -> dropWhile_(acc.tail, f)
            else -> acc
        }

    fun exists(p: (A) -> Boolean): Boolean = exists_(this, p)

    private tailrec fun exists_(stream: Stream<A>, p: (A) -> Boolean): Boolean = when {
        stream.isEmpty -> false
        p(stream.head) -> true
        else -> exists_(stream.tail, p)
    }

    fun takeWhile(f: (A) -> Boolean): Stream<A> =
        this.foldRight({ empty() }) { a ->
            { b -> if (f(a)) cons({ a }, b) else empty() }
        }

    fun headOptionViaFoldRight(): Result<A> = this.foldRight({ Result.empty() }) { a -> { Result.success(a) } }

    fun <B> map(f: (A) -> B): Stream<B> =
        this.foldRight({ empty() }) { a -> { b -> cons({ f(a) }, b) } }

    fun filter(p: (A) -> Boolean): Stream<A> =
        this.foldRight({ empty() }) { a ->
            { b -> if (p(a)) cons({ a }, b) else b() }
        }

    fun append(s: () -> Stream<A>): Stream<A> =
        this.foldRight(s) { a -> { b -> cons({ a }, b) } }

    fun <B> flatMap(f: (A) -> Stream<B>): Stream<B> =
        this.foldRight({ empty() }) { a -> { b -> f(a).append(b) } }

    fun find(p: (A) -> Boolean): Result<A> = this.filter(p).headOption()

    fun toList(): List<A> = toList_(this, list()).reverse()

    private tailrec fun toList_(stream: Stream<A>, acc: List<A>): List<A> =
        if (stream.isEmpty) acc
        else toList_(stream.tail, acc.cons(stream.head))
}

object Empty : Stream<Any?> {
    override val head: Any?
        get() = throw IllegalStateException("head called on empty")

    override val tail: Stream<Any?>
        get() = throw IllegalStateException("tail called on empty")

    override val isEmpty = true

    override fun headOption(): Result<Any?> = Result.empty()

    override fun take(n: Int): Stream<Any?> = this

    override fun drop(n: Int): Stream<Any?> = this

    override fun takeWhile_(f: (Any?) -> Boolean): Stream<Any?> = this

    override fun <B> foldRight(z: () -> B, f: (Any?) -> (Supplier<B>) -> B): B = z()
}

private class Cons<A>(head: () -> A, tail: () -> Stream<A>) : Stream<A> {
    override val head: A by lazy(head)
    override val tail: Stream<A> by lazy(tail)
    override val isEmpty: Boolean = false

    override fun headOption(): Result<A> = Result.success(head)

    override fun take(n: Int): Stream<A> =
        if (n <= 0) empty()
        else cons({ head }, { tail.take(n - 1) })

    override fun drop(n: Int): Stream<A> = drop_(this, n)

    private tailrec fun drop_(acc: Stream<A>, n: Int): Stream<A> =
        if (n <= 0) acc
        else drop_(acc.tail, n - 1)

    override fun takeWhile_(f: (A) -> Boolean): Stream<A> =
        if (f(head)) cons({ head }, { tail.takeWhile_(f) })
        else empty()

    override fun <B> foldRight(z: () -> B, f: (A) -> (Supplier<B>) -> B): B =
        f(head)({ tail.foldRight(z, f) })
}

@Suppress("UNCHECKED_CAST")
fun <A> empty(): Stream<A> = Empty as Stream<A>

fun <A> cons(head: () -> A, tail: () -> Stream<A>): Stream<A> = Cons(head, tail)

fun <A> cons(head: () -> A, tail: Stream<A>): Stream<A> = Cons(head, { tail })

fun from(i: Int): Stream<Int> = cons(head = { i }, tail = { from(i + 1) })