package com.gill.facadepattern;

/*
 * The facade pattern hides the complexities of the system and provides an 
 * interface to the client using which the client can access the system. 
 * This type of design pattern comes under structural pattern as this 
 * pattern adds an interface to existing system to hide its complexities.
 * For example, complex legacy code could be hidden behind a facade.
 * 
 * In this example, the ShapeMaker is a facade that creates a circle,
 * a rectangle and a square.  The client (i.e. this demo class) is oblivious
 * to the draw methods that get called on the circle, square and rectangle classes
 * and that these classes even exist.
 * 
 * http://www.tutorialspoint.com/design_pattern/facade_pattern.htm
 */
public class FacadeDemo {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}

}
