package com.fpinkotlin.handlingerrors.listing07_03_04_05

import com.fpinkotlin.handlingerrors.exercise07_04.Result
import com.fpinkotlin.handlingerrors.exercise07_04.failure
import com.fpinkotlin.handlingerrors.exercise07_04.success
import java.io.IOException

fun getName(): Result<String> {
//	return failure(IOException("Input error"))
//	return success("Minnie")
//	return success("Goofy")
	return success("Mickey")
}

fun main(args: Array<String>) {
	val toons = Map<String, Toon>()
			.put("Mickey", Toon("Mickey", "Mouse", "mickey@disney.com"))
			.put("Minnie", Toon("Minnie", "Mouse"))
			.put("Donald", Toon("Donald", "Duck", "donald@disney.com"))

	val result = getName().flatMap { toons[it] }.flatMap(Toon::email)

	println(result)
}
