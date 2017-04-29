package com.fpinkotlin.makingjavafunctional.exercise03_02

import com.fpinkotlin.makingjavafunctional.exercise03_01.Result

typealias Condition = () -> Boolean

fun <T> mcase(condition: Condition, value: () -> Result<T>) = Pair(condition, value)

fun <T> mcase(value: () -> Result<T>) = Pair({ true }, value)

fun <T> match(defaultCase: Pair<Condition, () -> Result<T>>,
              vararg matchers: Pair<Condition, () -> Result<T>>): Result<T> {
	for (matcher in matchers) {
		if (matcher.first()) return matcher.second()
	}
	return defaultCase.second()
}
