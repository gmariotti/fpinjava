package com.fpinkotlin.recursion.exercise04_08


import org.junit.Assert.assertEquals
import org.junit.Test

class ComposeAllTest {

	val f1: (String) -> String = { x -> "(a$x)" }
	val f2: (String) -> String = { x -> "{b$x}" }
	val f3: (String) -> String = { x -> "[c$x]" }
	val list = listOf(f1, f2, f3)

	@Test
	fun testComposeAllLeft() {
		assertEquals("(a{b[cx]})", composeAllViaFoldLeft(list)("x"))
	}

	@Test
	fun testComposeAllRight() {
		assertEquals("(a{b[cx]})", composeAllViaFoldRight(list)("x"))
	}

	@Test
	fun testAndThenAllLeft() {
		assertEquals("[c{b(ax)}]", andThenAllViaFoldLeft(list)("x"))
	}

	@Test
	fun testAndThenAllRight() {
		assertEquals("[c{b(ax)}]", andThenAllViaFoldRight(list)("x"))
	}
}
