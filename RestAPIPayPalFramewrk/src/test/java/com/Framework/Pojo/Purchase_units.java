package com.Framework.Pojo;

public class Purchase_units {

	private Amount amount;
	
	public Purchase_units(String currency_code,double value) {
		this.amount=new Amount(currency_code,value);
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	
}
