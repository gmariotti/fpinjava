package com.fpinkotlin.functions.exercise02_11

fun <T, U, V> ((T) -> (U) -> V).reverseArgs(): (U) -> (T) -> (V) = { u -> { t -> this(t)(u) } }
