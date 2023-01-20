
package com.shreeganesh.loan.app.customerServiceInterfaces;


import java.util.List;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;

public interface SanctionLetterService {


	public void updateSanctionLetter(CustomerDetails customerDetails);

	public List<CustomerDetails> getAllGenratedSanction();

	public CustomerDetails changeCustomerFormStatusSanctioned(Integer customerId, String customerStatus);


}