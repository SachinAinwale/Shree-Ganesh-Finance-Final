package com.shreeganesh.loan.app.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreeganesh.loan.app.customerEntities.Enquiry;
import com.shreeganesh.loan.app.customerServiceInterfaces.EnquiryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	EnquiryService enquiryService;
	
	@PostMapping("/insert")
	public ResponseEntity<Enquiry> insertData(@RequestBody Enquiry enq){
		
		Enquiry enquiry=enquiryService.insertData(enq);
		
		
		
		
		return new ResponseEntity<Enquiry>(enquiry,HttpStatus.CREATED);
	}
	

	@PutMapping("/cibilcheck")
	public ResponseEntity<Enquiry> cibilCheck(@RequestBody Enquiry enq)
	{
		
		return null;
	}
}
