package com.fpinkotlin.makingjavafunctional.exercise03_11

import com.fpinkotlin.makingjavafunctional.exercise03_10.append

fun range(start: Int, end: Int): List<Int> {
	var result: List<Int> = ArrayList()
	var temp = start
	while (temp < end) {
		result = append(result, temp)
		temp += 1
	}
	return result
}
