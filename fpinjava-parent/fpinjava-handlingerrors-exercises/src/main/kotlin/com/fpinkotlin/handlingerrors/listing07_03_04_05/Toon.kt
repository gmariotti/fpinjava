package com.fpinkotlin.handlingerrors.listing07_03_04_05


import com.fpinkotlin.handlingerrors.exercise07_04.failure
import com.fpinkotlin.handlingerrors.exercise07_04.success

class Toon(val firstName: String, val lastName: String, email: String = "") {
	val email =
			if (email == "") failure<String>("$firstName $lastName has no mail")
			else success(email)
}