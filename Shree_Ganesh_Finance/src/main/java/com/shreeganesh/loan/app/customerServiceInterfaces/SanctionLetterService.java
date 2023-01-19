package com.shreeganesh.loan.app.customerServiceInterfaces;


import com.shreeganesh.loan.app.customerEntities.CustomerDetails;
import com.shreeganesh.loan.app.customerEntities.SanctionLetter;

public interface SanctionLetterService {

	//public SanctionLetter insertData(SanctionLetter sanctionLetter, Integer customerId);

	public void updateSanctionLetter(CustomerDetails customerDetails);


}
