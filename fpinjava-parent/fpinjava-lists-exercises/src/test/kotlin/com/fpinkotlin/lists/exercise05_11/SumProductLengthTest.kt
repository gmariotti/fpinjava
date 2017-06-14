package com.fpinkotlin.lists.exercise05_11

import com.fpinkotlin.lists.exercise05_10.list
import org.junit.Assert.assertEquals
import org.junit.Test


class SumProductLengthTest {

	@Test
	fun testSumViaFoldLeft() {
		assertEquals(0, sumViaFoldLeft(list<Int>()))
		assertEquals(6, sumViaFoldLeft(list(1, 2, 3)))
	}

	@Test
	fun testProductViaFoldLeft() {
		assertEquals(1.0, productViaFoldLeft(list<Double>()), 0.0)
		assertEquals(24.0, productViaFoldLeft(list(1.0, 2.0, 3.0, 4.0)), 0.0)
	}

	@Test
	fun testLengthVaFoldLeft() {
		assertEquals(0, lengthViaFoldLeft(list<Any>()))
		assertEquals(4, lengthViaFoldLeft(list(1.0, 2.0, 3.0, 4.0)))
	}
}
