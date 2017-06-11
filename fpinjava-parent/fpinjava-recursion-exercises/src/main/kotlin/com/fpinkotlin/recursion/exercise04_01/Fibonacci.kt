package com.fpinkotlin.recursion.exercise04_01

import java.math.BigInteger


fun fib(x: Int): BigInteger {
	return fib_(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(x.toLong()))
}

private tailrec fun fib_(acc1: BigInteger, acc2: BigInteger, x: BigInteger): BigInteger {
	if (x == BigInteger.ZERO) {
		return BigInteger.ZERO
	} else if (x == BigInteger.ONE) {
		return acc1 + acc2
	} else {
		return fib_(acc2, acc1 + acc2, x - BigInteger.ONE)
	}
}

fun main(args: Array<String>) {
	print(fib(10000))
}