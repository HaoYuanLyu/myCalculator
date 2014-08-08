package com.example.mycalculator;

public class Caculator {

	private String myValue;
	Operator nowOperator;

	public void add(String number) {
		myValue = number;
		nowOperator = new Add();
	}

	public void sub(String number) {
		myValue = number;
		nowOperator = new Sub();
	}

	public void mul(String number) {
		myValue = number;
		nowOperator = new Mul();
	}

	public void div(String number) {
		myValue = number;
		nowOperator = new Div();
	}

	public String getValue() {
		return String.valueOf(myValue);
	}

	public void setValue(String number) {
		myValue = number;
	}

	public String Caculate(String number) {
		return nowOperator.calculate(myValue, number);
	}
}
