package com.shreeganesh.loan.app.customerEntities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDisbursement {

	@Id
	 private Integer agreementId;
	 private Long  loanNo;
	 private Double totalLoanAmount;
	 @OneToOne(cascade = CascadeType.ALL)
	 private DealerBankDetails dealerBankDetails;       
	 private Double transferAmount;
	// @Enumerated
	 private String paymentStatus;
	 private String amountPaidDate;
}
