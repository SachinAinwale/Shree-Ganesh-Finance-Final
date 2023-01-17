package com.shreeganesh.loan.app.customerController;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@PostMapping("/getAllData")
	public String getAllCustomeData(@RequestBody CustomerDetails customerDetails,
			@RequestPart("photo") MultipartFile file) {

		System.out.println(customerDetails);
		try {
			customerDetails.getCustomerAllDocuments().setPhoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "data added";
	}
	
	
	@GetMapping("/getFormDataById/{customerId}")
	public void getFormDataById(@PathVariable("customerId") Integer customerId)
	{
		
	}
	

}
