package com.shreeganesh.loan.app.customerUtil;

import java.util.Random;

public class Cibil {
	
	
	
	public Integer cibilCheck(String pan) {
		Random r=new Random();
		
		Integer i=r.nextInt(500,900);
		
		return i;
	}

}
