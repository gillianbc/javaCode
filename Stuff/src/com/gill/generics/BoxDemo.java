package com.gill.generics;

import java.util.ArrayList;
import java.util.List;

public class BoxDemo {
	
	/**
	 * For generics that'll be used in methods, we list the generics before the return type
	 * 
	 */

	// method that creates a box and adds it to the list of boxes
	// public method
	// will use <U> somewhere
	// return type is void
	// name is addBox
	// param 1 is of type U and called u
	// param 2 is of type List<Box<U>> and called boxes
	public static <U> void addBox(U u, List<Box<U>> boxes) {
		Box<U> box = new Box<>(); // note the DIAMOND. Type inference kicks in
									// as compiler knows we mean new Box<U>
		box.set(u);
		boxes.add(box);
		
	}

	// method that prints out the contents of a list of boxes
	// public static method (just gets built once for whole BoxDemo class so the counter persists between calls)
	// will use <U> somehwhere
	// return type is void
	// name is outputboxes
	// param 1 is of type List<Box<U>> called boxes
	public static <U> void outputBoxes(List<Box<U>> boxes) {
		int counter = 0;
		for (Box<U> box : boxes) {
			U boxContents = box.get();
			System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
			counter++;
		}
	}

	public static void main(String[] args) {
		ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();  //declare an array list of boxes for integers
		BoxDemo.<Integer> addBox(Integer.valueOf(10), listOfIntegerBoxes);  //could have left out <Integer> after BoxDemo - type inference.  It's called a 'type witness'
		BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		BoxDemo.outputBoxes(listOfIntegerBoxes);
	}
}
