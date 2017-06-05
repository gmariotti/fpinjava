package com.fpinkotlin.makingjavafunctional.exercise03_05

import org.junit.Test

import com.fpinjava.makingjavafunctional.exercise03_04.CollectionUtilities.list
import com.fpinjava.makingjavafunctional.exercise03_05.Fold.fold
import org.junit.Assert.assertEquals

class FoldTest {

	@Test
	fun testFold() {
		val emptyList = list<Int>()
		val single = list(1)
		val listInteger = list(1, 2, 3, 4, 5, 6)
		val func: (Int) -> (Int) -> (Int) = { x -> { y -> x + y } }
		assertEquals(Integer.valueOf(21), fold(listInteger, 0, func))
		assertEquals(Integer.valueOf(0), fold(emptyList, 0, func))
		assertEquals(Integer.valueOf(1), fold(single, 0, func))
	}
}
