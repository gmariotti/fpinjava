package com.fpinjava.functions.exercise02_05;

public interface Function<T, U> {

  U apply(T arg);

  static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
    return (Function<U, V> f1) -> (Function<T, U> f2) -> (T f3) -> f1.apply(f2.apply(f3));
  }
}
