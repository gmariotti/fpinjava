package com.fpinkotlin.makingjavafunctional.exercise03_01


import com.fpinkotlin.makingjavafunctional.exercise03_02.match
import com.fpinkotlin.makingjavafunctional.exercise03_02.mcase
import java.util.regex.Pattern

val emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
val success: (String) -> (Unit) = { s -> println("Mail sent to " + s) }
val failure: (String) -> (Unit) = { s -> System.err.println("Error message logged:" + s) }

val emailChecker: (String?) -> Result<String> = { s: String? ->
	match(
			mcase { Result.success(s!!) },
			mcase({ s == null }) { Result.failure<String>("email must not be null") },
			mcase({ s?.length == 0 }) { Result.success("email must not be empty") },
			mcase({ !emailPattern.matcher(s).matches() }) { Result.failure<String>("email $s is invalid") }
	)
}

fun main(args: Array<String>) {
	emailChecker("this.is@my.email").bind(success, failure)
	emailChecker(null).bind(success, failure)
	emailChecker("").bind(success, failure)
	emailChecker("john.doe@acme.com").bind(success, failure)
}
