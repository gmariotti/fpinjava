package com.fpinkotlin.recursion.exercise04_06

import com.fpinkotlin.common.compose
import com.fpinkotlin.recursion.exercise04_05.foldRight

fun <T> composeAll(list: List<(T) -> (T)>): (T) -> (T) =
		foldRight(list, { x -> x }) { x -> { f: (T) -> T -> x.compose(f) } }
