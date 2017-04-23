package com.fpinkotlin.functions.listing02_01

var percent1 = 5

private var percent2 = 9

val percent3 = 13

fun add(a: Int, b: Int): Int {
	return a + b
}

fun mult(a: Int, b: Int): Int {
	var a = a
	var b = b
	a = 5
	b = 2
	return a * b
}

fun div(a: Int, b: Int): Int {
	return a / b
}

fun applyTax1(a: Int): Int {
	return a / 100 * (100 + percent1)
}

fun applyTax2(a: Int): Int {
	return a / 100 * (100 + percent2)
}

fun applyTax3(a: Int): Int {
	return a / 100 * (100 + percent3)
}

fun append(i: Int, list: MutableList<Int>): List<Int> {
	list.add(i)
	return list
}

fun append2(i: Int, list: List<Int>): List<Int> {
	val result = mutableListOf<Int>()
	result.add(i)
	percent2++
	return result
}
