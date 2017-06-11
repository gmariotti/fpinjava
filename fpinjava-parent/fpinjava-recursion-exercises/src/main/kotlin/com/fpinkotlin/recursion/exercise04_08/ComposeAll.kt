package com.fpinkotlin.recursion.exercise04_08

import com.fpinkotlin.common.foldLeft
import com.fpinkotlin.common.foldRight

fun <T> composeAllViaFoldLeft(list: List<(T) -> T>): (T) -> (T) = { x ->
	list.reversed().foldLeft(x) { a -> { b -> b(a) } }
}

fun <T> composeAllViaFoldRight(list: List<(T) -> T>): (T) -> (T) = { x ->
	list.foldRight(x) { a -> a::invoke }
}

fun <T> andThenAllViaFoldLeft(list: List<(T) -> T>): (T) -> (T) = { x ->
	list.foldLeft(x) { a -> { b -> b(a) } }
}

fun <T> andThenAllViaFoldRight(list: List<(T) -> T>): (T) -> (T) = { x ->
	list.reversed().foldRight(x) { a -> a::invoke }
}
