package com.fpinjava.recursion.exercise04_05;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;
import com.fpinjava.common.TailCall;

import static com.fpinjava.common.CollectionUtilities.head;
import static com.fpinjava.common.CollectionUtilities.reverse;
import static com.fpinjava.common.CollectionUtilities.tail;
import static com.fpinjava.common.TailCall.ret;
import static com.fpinjava.common.TailCall.sus;

public class FoldRight {

	public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
		return foldRight_(identity, reverse(ts), f).eval();
	}

	private static <T, U> TailCall<U> foldRight_(U acc, List<T> ts, Function<T, Function<U, U>> f) {
		return ts.isEmpty()
				? ret(acc)
				: sus(() -> foldRight_(f.apply(head(ts)).apply(acc), tail(ts), f));
	}
}
