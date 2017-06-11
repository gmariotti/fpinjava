package com.fpinkotlin.recursion.exercise04_07

import com.fpinkotlin.common.foldLeft
import com.fpinkotlin.common.foldRight


fun <T> composeAll(list: List<(T) -> T>): (T) -> T = { x ->
	var result = x
	for (f in list) result = f(result)
	result
}

fun <T> composeAllViaFoldLeft(list: List<(T) -> T>): (T) -> (T) = { x ->
	list.foldLeft(x) { a -> { b -> b(a) } }
}

fun <T> composeAllViaFoldRight(list: List<(T) -> T>): (T) -> (T) = { x ->
	list.foldRight(x) { a -> a::invoke }
}
