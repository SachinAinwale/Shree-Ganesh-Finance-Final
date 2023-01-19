
package com.shreeganesh.loan.app.customerEntities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LoanDisbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer agreementId;
	private Long loanNo;
	private Double totalLoanAmount;
	@OneToOne(cascade = CascadeType.ALL)
	private DealerBankDetails dealerBankDetails;
	private Double transferAmount;
	// @Enumerated

	 private String paymentStatus;
	 private Date amountPaidDate;

	
}

