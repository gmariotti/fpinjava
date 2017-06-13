package com.fpinkotlin.lists.exercise05_08

import com.fpinkotlin.lists.exercise05_06.List

fun product(doubles: List<Double>): Double =
		if (doubles.empty) 1.0
		else if (doubles.head == 0.0) 0.0
		else doubles.head * product(doubles.tail)
