package com.shreeganesh.loan.app.customerServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreeganesh.loan.app.customerEntities.Enquiry;
import com.shreeganesh.loan.app.customerEnum.CustomerStatus;
import com.shreeganesh.loan.app.customerRepository.EnquiryRepository;
import com.shreeganesh.loan.app.customerServiceInterfaces.EnquiryService;
import com.shreeganesh.loan.app.customerUtil.Cibil;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository enquiryRepository;
	
	@Override
	public Enquiry insertData(Enquiry enq) {
		Cibil cibil=new Cibil();
		Integer cibilChecked = cibil.cibilCheck(enq.getEnquiryPanCard());
		if(cibilChecked>=750) {
			enq.setEnquiryStatus(String.valueOf(CustomerStatus.CibilOK));
		}
		else{
			enq.setEnquiryStatus(String.valueOf(CustomerStatus.CibilNotOK));
		}
		enq.setEnquiryCibilScore(cibilChecked);
		Enquiry enquiry = enquiryRepository.save(enq);
		System.out.println(enq);
		return enquiry;
	}

	@Override
	public List<Enquiry> getAllEnquiries() {
		return enquiryRepository.findAll();
		
	}

	@Override
	public List<Enquiry> getCibilOkEnquiries() {
		return enquiryRepository.findAllByEnquiryStatus(String.valueOf(CustomerStatus.CibilOK));
		
	}

}
