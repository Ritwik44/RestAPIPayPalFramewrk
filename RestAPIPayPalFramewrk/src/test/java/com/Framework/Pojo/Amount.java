package com.Framework.Pojo;

public class Amount {
	
	private String currency_code;
	private double value;
	
	public Amount(String currency_code,double value) {
		
		this.currency_code=currency_code;
		this.value=value;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	
}
