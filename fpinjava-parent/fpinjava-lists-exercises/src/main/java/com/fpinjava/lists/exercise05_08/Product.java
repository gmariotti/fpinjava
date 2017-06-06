package com.fpinjava.lists.exercise05_08;

import com.fpinjava.lists.exercise05_06.List;

public class Product {

	public static Double product(List<Double> doubles) {
		return doubles.isEmpty()
				? 1.0
				: doubles.head() == 0
				? 0.0
				: doubles.head() * product(doubles.tail());
	}
}
