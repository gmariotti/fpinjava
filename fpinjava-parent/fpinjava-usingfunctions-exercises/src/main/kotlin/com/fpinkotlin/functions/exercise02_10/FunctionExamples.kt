package com.fpinkotlin.functions.exercise02_10

fun <A, B, C> ((Pair<A, B>) -> C).curry(): (A) -> (B) -> (C) =
		{ a -> { b -> this(Pair(a, b)) } }

