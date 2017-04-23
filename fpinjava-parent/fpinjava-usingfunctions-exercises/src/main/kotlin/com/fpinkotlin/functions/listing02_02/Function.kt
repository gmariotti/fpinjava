package com.fpinkotlin.functions.listing02_02


fun <T> identity(): (T) -> (T) = { t -> t }

infix fun <T, U, V> ((U) -> (V)).compose(f: (T) -> (U)) =
		{ arg: T -> this(f(arg)) }

infix fun <T, U, V> ((U) -> (V)).andThen(f: (V) -> (T)) =
		{ arg: U -> f(this(arg)) }

fun <T, U, V> ((U) -> (V)).compose(): ((T) -> (U)) -> ((T) -> (V)) =
		{ f -> { x -> this(f(x)) } }

fun <T, U, V> ((T) -> (U)).andThen(): ((U) -> (V)) -> ((T) -> (V)) =
		{ f -> { x -> f(this(x)) } }
