package com.shreeganesh.loan.app.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;
import com.shreeganesh.loan.app.customerEntities.SanctionLetter;
import com.shreeganesh.loan.app.customerServiceInterfaces.SanctionLetterService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sanctionletter")
public class SanctionLetterController {
	
	@Autowired
	SanctionLetterService sls;
	
//	@PostMapping("/generatesanctionletter/{customerId}")
//	public ResponseEntity<SanctionLetter> insertData(@RequestBody SanctionLetter sanctionLetter,@PathVariable Integer customerId) {
//		
//		SanctionLetter data = sls.insertData(sanctionLetter,customerId);
//		//return new ResponseEntity<Enquiry>(enquiry, HttpStatus.CREATED);
//		 return new ResponseEntity<SanctionLetter>(data, HttpStatus.CREATED);
//	}
//	
	
	@PutMapping("/generateSanctionLetterByCustomer")
	public ResponseEntity<CustomerDetails> updateSanctionLetter(@RequestBody CustomerDetails customerDetails)
	{
		 sls.updateSanctionLetter(customerDetails);
		 return new ResponseEntity<CustomerDetails>( HttpStatus.CREATED);	
	}

}
