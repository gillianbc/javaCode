package com.gill.generics;

public class Animal<T> {
	private String name;
	private T t;
	public Animal(String name, T t) {
		super();
		this.name = name;
		this.t = t;
	}
	
	public void whatIsT(){
		System.out.println("Type T is " + t.getClass().getName());
	}

}
