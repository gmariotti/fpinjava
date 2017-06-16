package com.fpinkotlin.lists.exercise05_18

import com.fpinkotlin.lists.exercise05_16.List
import com.fpinkotlin.lists.exercise05_16.list

fun doubleToString(list: List<Double>): List<String> =
		list.foldRight(list<String>()) { head -> { tail -> tail.cons(head.toString()) } }
