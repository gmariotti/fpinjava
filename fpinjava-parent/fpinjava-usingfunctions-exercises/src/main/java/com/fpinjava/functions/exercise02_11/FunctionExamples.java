package com.fpinjava.functions.exercise02_11;


public class FunctionExamples {

  public static <T, U, V> Function<U, Function<T, V>> reverseArgs(Function<T, Function<U, V>> f) {
    return u -> t -> f.apply(t).apply(u);
  }
}
