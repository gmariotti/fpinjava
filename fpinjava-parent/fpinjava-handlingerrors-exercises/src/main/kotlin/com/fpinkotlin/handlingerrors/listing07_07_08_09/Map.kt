package com.fpinkotlin.handlingerrors.listing07_07_08_09

import com.fpinkotlin.handlingerrors.listing07_06.Result
import java.util.concurrent.ConcurrentHashMap

class Map<T, U> {

	private val map = ConcurrentHashMap<T, U>()

	operator fun get(t: T): Result<U> {
		return map[t]?.let { Result.success(it) } ?: Result.empty<U>()
//		return if (map.containsKey(t))
//			Result.success(map.get(t)!!)
//		else
//			Result.isEmpty<U>()
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
