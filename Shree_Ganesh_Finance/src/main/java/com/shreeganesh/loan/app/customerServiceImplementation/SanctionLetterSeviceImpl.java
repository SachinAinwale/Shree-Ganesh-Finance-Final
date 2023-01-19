package com.shreeganesh.loan.app.customerServiceImplementation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.shreeganesh.loan.app.customerEntities.LoanDisbursement;
import com.shreeganesh.loan.app.customerEntities.SanctionLetter;
import com.shreeganesh.loan.app.customerEnum.CustomerStatus;
import com.shreeganesh.loan.app.customerRepository.CustomerRepository;
import com.shreeganesh.loan.app.customerRepository.SanctionLetterRepository;
import com.shreeganesh.loan.app.customerServiceInterfaces.SanctionLetterService;

@Service
public class SanctionLetterSeviceImpl implements SanctionLetterService{
	
	@Autowired
	SanctionLetter sanletter;
	
	@Autowired
	SanctionLetterRepository sanrepo;
	
	@Autowired
	CustomerRepository custrepo;
	
	@Autowired
	JavaMailSender sender;

	private Logger	logger=LoggerFactory.getLogger(SanctionLetterSeviceImpl.class);

//	@Override
//	public SanctionLetter insertData(SanctionLetter sanctionLetter, Integer customerId) {
//		
//		Optional<CustomerDetails> cust=custrepo.findById(customerId);
//		CustomerDetails customer=cust.get();
//		
//		sanletter.setSanctionId(customer.getCustomerSanctionLetter().getSanctionId());
//		Date d=new Date();
//		sanletter.setSanctionDate(d);
//		sanletter.setApplicantName(customer.getCustomerFirstName()+" "+customer.getCustomerLastName());
//		sanletter.setLoanAmountSanctioned(customer.getLoanAmtSanction());
//		sanletter.setSactionStatus(String.valueOf(CustomerStatus.SanctionLetterGenreted));
//				
//		SanctionLetter san=sanrepo.save(sanletter);
//		customer.setCustomerSanctionLetter(san);
//		
//		custrepo.save(customer);
//		
//		logger.info("Loan Disbursement PDF started");
//		String title="Shree Ganesh Finace";
//		String content1="Dear Customer "+customer.getCustomerFirstName()+" "+customer.getCustomerLastName();
//		String content2="Shree Ganesh Finance is Happy to informed you that your application is sanction "
//				+ "loan is approved following are the details";
//		String content3="Sanction Id :"+customer.getCustomerSanctionLetter().getSanctionId()+"\n";
//		String content4="Sanction Loan :"+customer.getCustomerSanctionLetter().getLoanAmountSanctioned()+"\n";
//		String content5="Rate of Interest :"+customer.getCustomerSanctionLetter().getRateOfInterest()+"\n";
//		String content6="Emi monthy amount :"+customer.getCustomerSanctionLetter().getMonthlyEmiAmount()+"\n";
//		String content7="Loan tenure :"+customer.getCustomerSanctionLetter().getLoanTenure()+"\n";
//		String content8="total loan Amount with Intrest :"+customer.getCustomerSanctionLetter().getTotalLoanAmountWithInterest()+"\n";
//		
//		ByteArrayOutputStream opt=new ByteArrayOutputStream();
//		
//		Document document=new Document();
//		
//		PdfWriter.getInstance(document, opt);
//		document.open();
//		
//		Font titlefont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
//		Paragraph titlepara=new Paragraph(title,titlefont);
//		
//		titlepara.setAlignment(Element.ALIGN_CENTER);
//		
//		titlepara.setAlignment(Element.ALIGN_CENTER);
//		document.add(titlepara);
//		
//		Paragraph paracontent1=new Paragraph(content1);
//		document.add(paracontent1);
//		
//		Paragraph paracontent2=new Paragraph(content2);
//		document.add(paracontent2);
//		
//		Paragraph paracontent3=new Paragraph(content3);
//		document.add(paracontent3);
//		
//		Paragraph paracontent4=new Paragraph(content4);
//		document.add(paracontent4);
//		
//		Paragraph paracontent5=new Paragraph(content5);
//		document.add(paracontent5);
//		
//		Paragraph paracontent6=new Paragraph(content6);
//		document.add(paracontent6);
//		
//		Paragraph paracontent7=new Paragraph(content7);
//		document.add(paracontent7);
//		
//		Paragraph paracontent8=new Paragraph(content8);
//		document.add(paracontent8);
//		
//		document.close();
//		ByteArrayInputStream byt=new ByteArrayInputStream(opt.toByteArray());
//		
//		MimeMessage mimemessage=sender.createMimeMessage();
//		
//		try {
//			MimeMessageHelper mimemessageHelper=new MimeMessageHelper(mimemessage,true);
//			mimemessageHelper.setFrom("navinash111@gmail.com");
//			mimemessageHelper.setTo(customer.getCustomerEmail());
//			mimemessageHelper.setSubject("Shree Ganesh Finance regarding to Car loan" );
//			mimemessageHelper.setText("Dear Customer, We have recived sanction letter & happy to let you that we will get sanction amount");
//			byte[] bytearray=byt.readAllBytes();
//			
//			mimemessageHelper.addAttachment("loanDisbursmentletter.pdf", new ByteArrayResource(bytearray));
//			sender.send(mimemessage);
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		return san;
//	}
//
	@Override
	public void updateSanctionLetter(CustomerDetails customerDetails)
	{
	
		customerDetails.setCustomerStatus(String.valueOf(CustomerStatus.SanctionLetterGenreted));
		customerDetails.getCustomerSanctionLetter().setSactionStatus(String.valueOf(CustomerStatus.SanctionLetterGenreted));
		customerDetails.getCustomerSanctionLetter().setTermsCondition("Ok");
	

		logger.info("Loan Disbursement PDF started");
		String title="Shree Ganesh Finace";
		String content1="Dear Customer "+customerDetails.getCustomerFirstName()+" "+customerDetails.getCustomerLastName();
		String content2="Shree Ganesh Finance is Happy to informed you that your application is sanction "
				+ "loan is approved following are the details";
		String content3="Sanction Id :"+customerDetails.getCustomerSanctionLetter().getSanctionId()+"\n";
		String content4="Sanction Loan :"+customerDetails.getCustomerSanctionLetter().getLoanAmountSanctioned()+"\n";
		String content5="Rate of Interest :"+customerDetails.getCustomerSanctionLetter().getRateOfInterest()+"\n";
		String content6="Emi monthy amount :"+customerDetails.getCustomerSanctionLetter().getMonthlyEmiAmount()+"\n";
		String content7="Loan tenure :"+customerDetails.getCustomerSanctionLetter().getLoanTenure()+"\n";
		String content8="total loan Amount with Intrest :"+customerDetails.getCustomerSanctionLetter().getTotalLoanAmountWithInterest()+"\n";
		
		ByteArrayOutputStream opt=new ByteArrayOutputStream();
		
		Document document=new Document();
		
		PdfWriter.getInstance(document, opt);
		document.open();
		
		Font titlefont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		Paragraph titlepara=new Paragraph(title,titlefont);
		
		titlepara.setAlignment(Element.ALIGN_CENTER);
		
		titlepara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlepara);
		
		Paragraph paracontent1=new Paragraph(content1);
		document.add(paracontent1);
		
		Paragraph paracontent2=new Paragraph(content2);
		document.add(paracontent2);
		
		Paragraph paracontent3=new Paragraph(content3);
		document.add(paracontent3);
		
		Paragraph paracontent4=new Paragraph(content4);
		document.add(paracontent4);
		
		Paragraph paracontent5=new Paragraph(content5);
		document.add(paracontent5);
		
		Paragraph paracontent6=new Paragraph(content6);
		document.add(paracontent6);
		
		Paragraph paracontent7=new Paragraph(content7);
		document.add(paracontent7);
		
		Paragraph paracontent8=new Paragraph(content8);
		document.add(paracontent8);
		
		document.close();
		ByteArrayInputStream byt=new ByteArrayInputStream(opt.toByteArray());
		
		MimeMessage mimemessage=sender.createMimeMessage();
		
		try {
			MimeMessageHelper mimemessageHelper=new MimeMessageHelper(mimemessage,true);
			mimemessageHelper.setFrom("arkanshaikh2019@gmail.com");
			mimemessageHelper.setTo(customerDetails.getCustomerEmail());
			mimemessageHelper.setSubject("Shree Ganesh Finance regarding to Car loan" );
			mimemessageHelper.setText("Dear Customer, We have recived sanction letter & happy to let you that we will get sanction amount");
			byte[] bytearray=byt.readAllBytes();
			
			mimemessageHelper.addAttachment("loanDisbursmentletter.pdf", new ByteArrayResource(bytearray));
			sender.send(mimemessage);
		
			//customerDetails.getCustomerSanctionLetter().setSactionLetter(bytearray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		custrepo.save(customerDetails);
		
	}
	
	
	

}
