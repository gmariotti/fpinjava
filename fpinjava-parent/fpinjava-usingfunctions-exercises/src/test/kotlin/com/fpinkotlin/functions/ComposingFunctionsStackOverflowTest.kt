package com.fpinkotlin.functions

import org.junit.Test

class ComposingFunctionsStackOverflowTest {

	@Test(expected = StackOverflowError::class)
	fun test() {
		ComposingFunctionsStackOverflow.g(0)
	}
}
