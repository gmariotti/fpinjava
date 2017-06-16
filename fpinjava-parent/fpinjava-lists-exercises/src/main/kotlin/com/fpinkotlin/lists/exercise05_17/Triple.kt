package com.fpinkotlin.lists.exercise05_17

import com.fpinkotlin.lists.exercise05_16.List
import com.fpinkotlin.lists.exercise05_16.list

fun triple(list: List<Int>): List<Int> =
		list.foldRight(list<Int>()) { head -> { tail -> tail.cons(head * 3) } }
