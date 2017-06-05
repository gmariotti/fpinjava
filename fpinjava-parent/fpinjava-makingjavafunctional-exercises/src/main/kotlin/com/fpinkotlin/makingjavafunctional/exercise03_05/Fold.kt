package com.fpinkotlin.makingjavafunctional.exercise03_05

fun fold(list: List<Int>, identity: Int, f: (Int) -> (Int) -> (Int)): Int {
	var result = identity
	for (num in list) {
		result = f(result)(num)
	}
	return result
}
