package exercise04_01

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigInteger

class FibonacciTest {

	@Test
	fun testFib() {
		assertEquals(BigInteger.ZERO, fib(0))
		assertEquals(BigInteger.ONE, fib(1))
		assertEquals(BigInteger.ONE, fib(2))
		assertEquals(BigInteger.valueOf(5), fib(5))
		assertEquals(BigInteger.valueOf(55), fib(10))
		assertEquals(BigInteger("354224848179261915075"), fib(100))
	}
}
