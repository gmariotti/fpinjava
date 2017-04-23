package com.fpinkotlin.functions.exercise02_05

infix fun <T, U, V> ((U) -> (V)).compose(f: (T) -> (U)) =
		{ arg: T -> this(f(arg)) }
