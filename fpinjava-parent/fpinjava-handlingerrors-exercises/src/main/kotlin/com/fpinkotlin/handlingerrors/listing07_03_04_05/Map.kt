package com.fpinkotlin.handlingerrors.listing07_03_04_05

import com.fpinkotlin.handlingerrors.exercise07_04.Result
import com.fpinkotlin.handlingerrors.exercise07_04.failure
import com.fpinkotlin.handlingerrors.exercise07_04.success
import java.util.concurrent.ConcurrentHashMap

class Map<T, U> {

	private val map = ConcurrentHashMap<T, U>()

	operator fun get(t: T): Result<U> {
		return if (map.containsKey(t))
			success(map[t]!!)
		else
			failure<U>("Key $t not found in map")
	}

	fun put(t: T, u: U): Map<T, U> {
		map.put(t, u)
		return this
	}

	fun removeKey(t: T): Map<T, U> {
		map.remove(t)
		return this
	}
}

fun <T, U> empty(): Map<T, U> {
	return Map()
}

fun <T, U> add(map: Map<T, U>, t: T, u: U): Map<T, U> {
	return map.put(t, u)
}
