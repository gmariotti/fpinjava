package com.fpinjava.makingjavafunctional.exercise03_01;

// Consumer can be used too
public interface Effect<T> {
	void apply(T t);
}