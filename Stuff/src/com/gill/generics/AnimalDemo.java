package com.gill.generics;

public class AnimalDemo {

	public static void main(String[] args) {
		Animal<String> george = new Animal<>("Gorilla","Brown");
		george.whatIsT();
		
		Animal<Integer> david = new Animal<>("Bear",10);
		david.whatIsT();
		AnimalDemo d = new AnimalDemo();
		AnimalDemo.Vehicle ship;
		
		
//		Second<Vehicle> second = new Second<>();
		
	}
	public class Vehicle{
		private String colour;
		public Vehicle(String colour){
			this.colour = colour;
		}
		public String getColour(){
			System.out.println("Colour of vehicle is " + colour);
			return colour;
		}
	}
	public class Dwelling{
		private String colour;
		public Dwelling(String colour){
			this.colour = colour;
		}
		public String getColour(){
			System.out.println("Colour of dwelling is " + colour);
			return colour;
		}
	}
	
	public class First<T> {
		public <T> void display(T t){
			System.out.println("Name of class of t is " + t.getClass().getName());
		}
	}

	public class Second<T extends Vehicle> extends First<T> {
		public <T> void display(T t){
			System.out.println("Simple name of class of t is " + t.getClass().getSimpleName());
		}
	}

//	public class Third<T> extends Second<T> {} //Compile-time error

}
