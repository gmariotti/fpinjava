package com.fpinkotlin.optionaldata.exercise06_07

import com.fpinkotlin.common.List
import com.fpinkotlin.optionaldata.exercise06_06.Option
import com.fpinkotlin.optionaldata.exercise06_06.none
import com.fpinkotlin.optionaldata.exercise06_06.some

val sum: (List<Double>) -> Double = { list -> list.foldLeft(0.0) { x -> { y -> x + y } } }

val mean: (List<Double>) -> Option<Double> =
		{ list -> if (list.empty) none() else some(sum(list) / list.length()) }

val variance: (List<Double>) -> Option<Double> =
		{ list -> mean(list).flatMap { m -> mean(list.map { Math.pow(it - m, 2.0) }) } }
