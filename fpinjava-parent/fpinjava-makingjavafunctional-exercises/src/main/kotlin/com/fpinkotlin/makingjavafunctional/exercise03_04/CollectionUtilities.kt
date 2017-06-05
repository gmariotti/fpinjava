package com.fpinkotlin.makingjavafunctional.exercise03_04

fun <T> list(): List<T> = emptyList()

fun <T> list(t: T): List<T> = listOf(t)

fun <T> list(ts: List<T>): List<T> = ts.takeLast(ts.size)

fun <T> list(vararg t: T): List<T> = listOf(*t)

fun <T> head(list: List<T>): T = list.first()

fun <T> copy(ts: List<T>): List<T> = list(ts)

fun <T> tail(list: List<T>): List<T> {
	if (list.isEmpty()) {
		throw IllegalStateException()
	}
	return list.takeLast(list.size - 1)
}
