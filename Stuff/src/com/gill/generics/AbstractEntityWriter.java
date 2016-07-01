package com.gill.generics;

public abstract class AbstractEntityWriter<T> {
	
	public void writeOut(T t){
		System.out.println("AbstractEntityWriter: Printing for class " + t.getClass().getName());
	}
	
	
}
