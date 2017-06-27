package com.fpinkotlin.handlingerrors.listing07_07_08_09

import com.fpinkotlin.handlingerrors.listing07_06.Result

fun getName(): Result<String> {
//	return Result.failure(IOException("Input error"))
//	return Result.success("Minnie")
	return Result.success("Goofy")
//	return Result.success("Mickey")
}

fun main(args: Array<String>) {
	val toons = Map<String, Toon>()
			.put("Mickey", Toon("Mickey", "Mouse", "mickey@disney.com"))
			.put("Minnie", Toon("Minnie", "Mouse"))
			.put("Donald", Toon("Donald", "Duck", "donald@disney.com"))

	val result = getName().flatMap { toons[it] }.flatMap(Toon::email)

	println(result)
}
