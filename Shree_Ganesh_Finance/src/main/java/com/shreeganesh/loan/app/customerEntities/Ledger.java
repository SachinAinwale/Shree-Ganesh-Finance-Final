package com.shreeganesh.loan.app.customerEntities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ledger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ledgerId;
	private String ledgerCreatedDate;
	private Double totalLoanAmount;
	private Double payableAmountwithInterest;
	private Integer tenure;
	private Double monthlyEMI;
	private Double amountPaidtillDate;
	private Double remainingAmount;
	private String nextEmiDatestart;
	private String nextEmiDateEnd;
	private Integer defaulterCount;
	private String previousEmitStatus;
	private String currentMonthEmiStatus;
	private String loanEndDate;
//@Enumerated
	private String loanStatus;

}
