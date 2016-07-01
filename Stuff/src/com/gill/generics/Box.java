package com.gill.generics;

/**
 * Generic version of the Box class.
 * @param <T> the type of value being boxed
 * i.e. the class will use a type T - we don't know how yet
 * but it prevents boxes that are for Strings being used for
 * Integers etc at compile time
 * No constructor i.e. default constructor is enough
 */

public class Box<T> {
	// A Box has a property of type T
    private T t; // T stands for "Type"          
    //a setter
    public void set(T t) {
        this.t = t;
    }
    //a getter
    public T get() {
        return t;
    }
}

