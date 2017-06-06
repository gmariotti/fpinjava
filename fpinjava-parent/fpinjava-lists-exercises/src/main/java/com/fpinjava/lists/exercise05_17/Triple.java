package com.fpinjava.lists.exercise05_17;

import com.fpinjava.lists.exercise05_16.List;

public class Triple {

  public static List<Integer> triple(List<Integer> list) {
    return List.foldRight(list, List.<Integer>list(), head -> tail -> tail.cons(head * 3));
  }
}
