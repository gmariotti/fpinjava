package com.fpinkotlin.lists.exercise05_12

import com.fpinkotlin.lists.exercise05_10.List
import com.fpinkotlin.lists.exercise05_10.list

fun <A> reverseViaFoldLeft(list: List<A>): List<A> =
		list.foldLeft(list()) { x -> { x.cons(it) } }
