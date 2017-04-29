package com.fpinjava.recursion.exercise04_07;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.foldLeft;
import static com.fpinjava.common.CollectionUtilities.foldRight;

public class ComposeAll {

	public static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
		return x -> {
			T y = x;
			for (Function<T, T> f : list) {
				y = f.apply(y);
			}
			return y;
		};
	}

	public static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
		return x -> foldLeft(list, x, a -> b -> b.apply(a));
	}

	public static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
		return x -> foldRight(list, x, a -> a::apply);
	}
}
