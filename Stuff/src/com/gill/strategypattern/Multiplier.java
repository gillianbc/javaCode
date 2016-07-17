package com.gill.strategypattern;

public class Multiplier implements Strategy {

	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}

}
