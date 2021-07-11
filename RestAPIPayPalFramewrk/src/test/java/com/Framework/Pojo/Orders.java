package com.Framework.Pojo;

import java.util.ArrayList;

public class Orders {

	private String intent;
	private ArrayList<Purchase_units> purchase_units;
//	private Amount amount;
	
	public Orders(String intent,ArrayList<Purchase_units> purchase_units) {
		
		this.intent=intent;
		this.purchase_units=purchase_units;
	//	this.amount=new Amount(currency,amount);
		
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public ArrayList<Purchase_units> getPurchase_units() {
		return purchase_units;
	}

	public void setPurchase_units(ArrayList<Purchase_units> purchase_units) {
		this.purchase_units = purchase_units;
	}
	
/*	public void setAmount() {
		purchase_units.add(amount);  
		
	} */
	
}
