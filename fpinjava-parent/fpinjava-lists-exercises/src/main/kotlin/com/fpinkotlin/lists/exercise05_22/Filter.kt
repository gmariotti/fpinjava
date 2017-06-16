package com.fpinkotlin.lists.exercise05_22

import com.fpinkotlin.lists.exercise05_21.List
import com.fpinkotlin.lists.exercise05_21.list

fun <A> filterViaFlatMap(list: List<A>, p: (A) -> Boolean): List<A> =
		list.flatMap { x -> if (p(x)) list(x) else list<A>() }
