package com.fpinkotlin.optionaldata.exercise06_07

import com.fpinkotlin.common.list
import org.junit.Assert.assertEquals
import org.junit.Test

class VarianceTest {

	@Test
	fun testVariance() {
		val list = list(1.0, 2.0, 3.0, 4.0, 5.0)
		assertEquals("Some(2.0)", variance(list).toString())
	}

	@Test
	fun testVarianceEmpty() {
		val list = list<Double>()
		assertEquals("None", variance(list).toString())
	}

}
