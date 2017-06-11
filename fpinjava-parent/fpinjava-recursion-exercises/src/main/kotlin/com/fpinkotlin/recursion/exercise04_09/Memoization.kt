package com.fpinkotlin.recursion.exercise04_09

import com.fpinkotlin.common.TailCall
import com.fpinkotlin.common.TailCall.Companion.ret
import com.fpinkotlin.common.TailCall.Companion.sus
import com.fpinkotlin.common.append
import java.math.BigInteger

fun fibo(number: Int): String {
	val list = fibo_(
			listOf(BigInteger.ZERO),
			BigInteger.ONE,
			BigInteger.ZERO,
			BigInteger.valueOf(number.toLong())
	)()
	return list.joinToString(", ")
}

private fun fibo_(acc: List<BigInteger>,
                  acc1: BigInteger,
                  acc2: BigInteger,
                  x: BigInteger): TailCall<List<BigInteger>> {
	return if (x == BigInteger.ZERO)
		ret(acc)
	else if (x == BigInteger.ONE)
		ret(acc.append(acc1.add(acc2)))
	else
		sus { fibo_(acc.append(acc1.add(acc2)), acc2, acc1.add(acc2), x.subtract(BigInteger.ONE)) }
}
