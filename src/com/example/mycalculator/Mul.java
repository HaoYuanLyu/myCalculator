package com.example.mycalculator;

public class Mul extends Operator {

	@Override
	String calculate(String value1, String value2) {
		return String.valueOf(Float.valueOf(value1) * Float.valueOf(value2));
	}

}
