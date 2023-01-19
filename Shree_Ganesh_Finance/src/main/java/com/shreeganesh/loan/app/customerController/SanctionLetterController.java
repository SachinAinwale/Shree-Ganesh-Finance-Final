package com.shreeganesh.loan.app.customerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;
import com.shreeganesh.loan.app.customerServiceInterfaces.SanctionLetterService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sanctionletter")
public class SanctionLetterController {

	@Autowired
	SanctionLetterService sls;

	@PutMapping("/generateSanctionLetterByCustomer")
	public ResponseEntity<CustomerDetails> updateSanctionLetter(@RequestBody CustomerDetails customerDetails) {
		sls.updateSanctionLetter(customerDetails);
		return new ResponseEntity<CustomerDetails>(HttpStatus.CREATED);
	}

	@GetMapping("/getAllGenratedSanction")
	public ResponseEntity<List<CustomerDetails>> getAllGenratedSanction() {

		List<CustomerDetails> genratedSanction = sls.getAllGenratedSanction();

		return new ResponseEntity<List<CustomerDetails>>(genratedSanction, HttpStatus.OK);
	}

}
