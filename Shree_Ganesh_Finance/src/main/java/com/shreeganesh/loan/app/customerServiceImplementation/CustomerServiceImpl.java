package com.shreeganesh.loan.app.customerServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;
import com.shreeganesh.loan.app.customerEntities.Enquiry;
import com.shreeganesh.loan.app.customerEnum.CustomerStatus;
import com.shreeganesh.loan.app.customerRepository.CustomerRepository;
import com.shreeganesh.loan.app.customerRepository.EnquiryRepository;
import com.shreeganesh.loan.app.customerServiceInterfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	EnquiryRepository enquiryRepository;

	@Override
	public CustomerDetails fillLoanApplicationForm(CustomerDetails details) {

		details.setCustomerStatus(String.valueOf(CustomerStatus.DocumentsSubmitted));

		Optional<Enquiry> optional = enquiryRepository.findById(details.getCustomerId());
		if (optional.isPresent()) {
			Enquiry enquiry = optional.get();
			enquiry.setEnquiryStatus(String.valueOf(CustomerStatus.DocumentsSubmitted));
			enquiryRepository.save(enquiry);

		}

		return customerRepository.save(details);

	}

	@Override
	public CustomerDetails getByCustomerId(Integer customerId) {
		Optional<CustomerDetails> optional = customerRepository.findById(customerId);

		if (optional.isPresent()) {

			CustomerDetails customerDetails = optional.get();
			return customerDetails;
		} else {
			return null;
		}

	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerDetails changeCustomerFormStatus(Integer customerId, String customerStatus) {
		Optional<CustomerDetails> findById = customerRepository.findAllByCustomerStatus(String.valueOf(CustomerStatus.DocumentsSubmitted));

		if (findById.isPresent()) {
			CustomerDetails customerDetails = findById.get();
			customerDetails.setCustomerStatus(customerStatus);

			return customerRepository.save(customerDetails);

		}
		return null;

	}

}
