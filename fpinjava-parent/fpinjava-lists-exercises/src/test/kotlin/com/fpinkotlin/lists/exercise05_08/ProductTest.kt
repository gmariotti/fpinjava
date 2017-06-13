package com.fpinkotlin.lists.exercise05_08

import com.fpinkotlin.lists.exercise05_06.list
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductTest {

	@Test
	fun testSum() {
		assertEquals(1.0, product(list<Double>()), 0.0)
		assertEquals(30.0, product(list(1.0, 2.0, 3.0, 5.0)), 0.0)
	}
}
