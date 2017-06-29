package com.fpinkotlin.handlingerrors.listing07_07_08_09

import com.fpinkotlin.handlingerrors.listing07_06.Result

class Toon(val firstName: String, val lastName: String, email: String = "") {
	val email =
			if (email == "") Result.empty<String>()
			else Result.success(email)
}