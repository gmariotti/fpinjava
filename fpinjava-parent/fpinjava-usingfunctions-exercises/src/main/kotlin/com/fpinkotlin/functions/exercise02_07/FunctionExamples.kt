package com.fpinkotlin.functions.exercise02_07

infix fun <A, B, C> ((A) -> (B) -> (C)).partialA(a: A) = this(a)
