package com.fpinjava.functions.exercise02_09;

public class FunctionExamples {

  private static String format = "%s, %s, %s, %s";

  public static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> f() {
    return a -> b -> c -> d -> String.format("%s, %s, %s, %s", a, b, c, d);
  }
}
