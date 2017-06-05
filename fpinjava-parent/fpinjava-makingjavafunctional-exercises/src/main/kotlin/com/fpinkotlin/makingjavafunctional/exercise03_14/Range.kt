package com.fpinkotlin.makingjavafunctional.exercise03_14

import com.fpinkotlin.makingjavafunctional.exercise03_13.list
import com.fpinkotlin.makingjavafunctional.exercise03_13.prepend


fun range(start: Int, end: Int): List<Int> =
		if (end <= start) list() else prepend(start, range(start + 1, end))
