package com.fpinkotlin.functions

import com.fpinkotlin.functions.listing02_02.compose

object ComposingFunctionsStackOverflow {

	val fnum = 20000
	var g: (Int) -> (Int) = { x -> x }
	val f: (Int) -> (Int) = { x -> x + 1 }

	init {
		for (i in 0 until fnum) {
			g = g compose f
		}
	}
}
