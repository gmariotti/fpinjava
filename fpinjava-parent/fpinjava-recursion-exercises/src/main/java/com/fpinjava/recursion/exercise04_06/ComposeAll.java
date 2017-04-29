package com.fpinjava.recursion.exercise04_06;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.foldRight;
import static com.fpinjava.common.Function.identity;


public class ComposeAll {

	static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
		return foldRight(list, identity(), x -> x::compose);
	}
}
