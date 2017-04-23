package com.fpinkotlin.functions.exercise02_06

infix fun <T, U, V> ((U) -> (V)).compose(f: (T) -> (U)) =
		{ arg: T -> this(f(arg)) }

infix fun <T, U, V> ((U) -> (V)).andThen(f: (V) -> (T)) =
		{ arg: U -> f(this(arg)) }
