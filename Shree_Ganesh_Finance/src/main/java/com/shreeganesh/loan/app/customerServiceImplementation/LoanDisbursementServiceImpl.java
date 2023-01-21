package com.shreeganesh.loan.app.customerServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;
import com.shreeganesh.loan.app.customerEntities.Enquiry;
import com.shreeganesh.loan.app.customerEntities.LoanDisbursement;
import com.shreeganesh.loan.app.customerEnum.CustomerStatus;
import com.shreeganesh.loan.app.customerRepository.CustomerRepository;
import com.shreeganesh.loan.app.customerRepository.EnquiryRepository;
import com.shreeganesh.loan.app.customerRepository.LoanDisbursementRepository;
import com.shreeganesh.loan.app.customerServiceInterfaces.LoanDisbursementService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LoanDisbursementServiceImpl implements LoanDisbursementService {

	@Autowired
	LoanDisbursement loan;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	JavaMailSender sender;
	
	@Autowired
	EnquiryRepository enquiryRepository;

	private Logger logger = LoggerFactory.getLogger(LoanDisbursement.class);

	@Override
	public CustomerDetails insertData(Integer customerid) {

		Optional<CustomerDetails> optional = customerRepository.findById(customerid);

		if (optional.isPresent()) {

			CustomerDetails customer = optional.get();

			Date date = new Date();

			customer.getCustomerloandisbursement().setLoanNo(ThreadLocalRandom.current().nextLong(999, 9999));
			customer.getCustomerloandisbursement()
					.setTotalLoanAmount(customer.getCustomerSanctionLetter().getLoanAmountSanctioned());
			customer.getCustomerloandisbursement()
					.setTransferAmount(customer.getCustomerSanctionLetter().getLoanAmountSanctioned());
			customer.getCustomerloandisbursement()
					.setDealerBankDetails(customer.getCustomerDealer().getDealerBankDetails());
			customer.getCustomerloandisbursement().setPaymentStatus(String.valueOf(CustomerStatus.loandisbursed));
			customer.setCustomerStatus(String.valueOf(CustomerStatus.loandisbursed));
			customer.getCustomerloandisbursement().setAmountPaidDate(date);

			customerRepository.save(customer);
			
			Optional<Enquiry> optional1 = enquiryRepository.findById(customer.getCustomerId());
			if (optional.isPresent()) {
				Enquiry enquiry = optional1.get();
				enquiry.setEnquiryStatus(String.valueOf(CustomerStatus.loandisbursed));
				enquiryRepository.save(enquiry);

			}


//			logger.info("Loan Disbursement PDF started");
//
//			String title = "Shree Ganesh Finace";
//			String content1 = "mr" + customer.getCustomerDealer().getDealerName();
//			String content2 = "as per your vehicle quatation provided to" + customer.getCustomerFirstName() + " "
//					+ customer.getCustomerLastName() + "And further application aproved loan amount "
//					+ customer.getCustomerSanctionLetter().getLoanAmountSanctioned()
//					+ "is sanctiond by shree ganeh finace and amount is tranfer to your account"
//					+ customer.getCustomerDealer().getDealerBankDetails();
//			String content3 = "Thanks for chossing shree Ganesh Finace, hope your expiriance is pleasant";
//
//			ByteArrayOutputStream opt = new ByteArrayOutputStream();
//
//			Document document = new Document();
//
//			PdfWriter.getInstance(document, opt);
//			document.open();
//
//			Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
//			Paragraph titlepara = new Paragraph(title, titlefont);
//
//			titlepara.setAlignment(Element.ALIGN_CENTER);
//			document.add(titlepara);
//
//			Paragraph paracontent1 = new Paragraph(content1);
//			document.add(paracontent1);
//
//			Paragraph paracontent2 = new Paragraph(content2);
//			document.add(paracontent2);
//
//			Paragraph paracontent3 = new Paragraph(content3);
//			document.add(paracontent3);
//
//			document.close();
//			ByteArrayInputStream byt = new ByteArrayInputStream(opt.toByteArray());
//
//			MimeMessage mimemessage = sender.createMimeMessage();
//
//			try {
//				MimeMessageHelper mimemessageHelper = new MimeMessageHelper(mimemessage, true);
//				mimemessageHelper.setFrom("navinash111@gmail.com");
//				mimemessageHelper.setTo(customer.getCustomerDealer().getDealerEmail());
//				mimemessageHelper.setSubject("Shree Ganesh Finance regarding to Car loan");
//				mimemessageHelper.setText(
//						"Dear Dealer, We have recived sanction letter & happy to let you that we will get sanction amount");
//				byte[] bytearray = byt.readAllBytes();
//
//				mimemessageHelper.addAttachment("loanDisbursmentletter.pdf", new ByteArrayResource(bytearray));
//				sender.send(mimemessage);
//
//			} catch (Exception e) {
//				
//				e.printStackTrace();
//			}
			return customer;
		}
		else {
			return null;
		}
		
	}

}
