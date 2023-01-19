package com.shreeganesh.loan.app.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;
import com.shreeganesh.loan.app.customerEntities.LoanDisbursement;
import com.shreeganesh.loan.app.customerServiceInterfaces.LoanDisbursementService;

@CrossOrigin("*")
@RestController
@RequestMapping("/loandisbursement")
public class LoanDisbursementController {

	@Autowired
	LoanDisbursementService loandisbursementService;

	@PostMapping("/insert")
	public ResponseEntity<LoanDisbursement> insertData(@RequestBody CustomerDetails customer) {

		LoanDisbursement data = loandisbursementService.insertData(customer);
		return new ResponseEntity<LoanDisbursement>(data, HttpStatus.CREATED);
	}
}
