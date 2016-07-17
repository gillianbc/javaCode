package com.gill.strategypattern;

public class Operator {
	private Strategy strategy;

	public Operator(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}
