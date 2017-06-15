package com.fpinkotlin.lists.exercise05_13

import com.fpinkotlin.lists.exercise05_10.List
import com.fpinkotlin.lists.exercise05_10.foldRight

fun <A, B> foldRightViaFoldLeft(list: List<A>, identity: B, f: (A) -> (B) -> B): B =
		list.reverse().foldLeft(identity) { b -> { a -> f(a)(b) } }

fun <A, B> foldLeftViaFoldRight(list: List<A>, identity: B, f: (B) -> (A) -> B): B =
		foldRight(list.reverse(), identity) { a -> { b -> f(b)(a) } }
