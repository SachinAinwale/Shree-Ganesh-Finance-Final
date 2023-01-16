package com.shreeganesh.loan.app.customerEntities;



import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SanctionLetter {
     @Id
	private Integer sanctionId;
	private String sanctionDate;
	private String applicantName;
	private String contactDetails;
	private Double loanAmountSanctioned;
	private Double rateOfInterest;
	private Integer loanTenure;
	private Double monthlyEmiAmount;
	private String termsCondition;
	//@Enumerated
	private String sactionStatus;
	private byte[] sactionLetter;
}
