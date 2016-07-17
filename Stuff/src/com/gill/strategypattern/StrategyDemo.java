package com.gill.strategypattern;

public class StrategyDemo {

	public static void main(String[] args) {
		Operator operator = new Operator(new Adder());
		System.out.println(" 2 plus 1 is " + operator.executeStrategy(2, 1));
		
		Operator operator2 = new Operator(new Subtracter());
		System.out.println(" 2 minus 1 is " + operator2.executeStrategy(2, 1));
		
		Operator operator3 = new Operator(new Multiplier());
		System.out.println(" 2 times 3 is " + operator3.executeStrategy(2, 3));
		
	}

}
