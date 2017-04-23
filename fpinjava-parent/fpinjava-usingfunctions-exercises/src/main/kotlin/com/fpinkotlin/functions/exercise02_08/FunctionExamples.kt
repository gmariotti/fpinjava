package com.fpinkotlin.functions.exercise02_08

infix fun <A, B, C> ((A) -> (B) -> (C)).partialB(b: B) = { a: A -> this(a)(b) }
