package com.fpinkotlin.functions.exercise02_09

fun <A, B, C, D> A.f(): (B) -> (C) -> (D) -> (String) =
		{ b -> { c -> { d -> "$this, $b, $c, $d" } } }
