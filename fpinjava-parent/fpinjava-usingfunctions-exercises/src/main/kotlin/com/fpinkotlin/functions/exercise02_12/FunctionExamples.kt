package com.fpinkotlin.functions.exercise02_12;


object FunctionExamples {
	lateinit var factorial0: (Int) -> (Int)

	init {
		factorial0 = { n -> if (n <= 1) n else n * factorial0(n - 1) }
	}

	fun factorial1(): (Int) -> (Int) = { n -> if (n <= 1) n else n * factorial1()(n - 1) }
}
