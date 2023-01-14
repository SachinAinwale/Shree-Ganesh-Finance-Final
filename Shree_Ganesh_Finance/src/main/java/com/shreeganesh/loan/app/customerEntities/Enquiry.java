package com.shreeganesh.loan.app.customerEntities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {
	@Id
	private Integer enquiryId;
	private String enquiryFirstName;
	private String enquiryMiddleName;
	private String enquiryLastName;
	private Long enquiryMobileNumber;
	private String enquiryPanCard;
	private Long enquiryAdhaarCard;
	private String enquiryAddress;
	private String enquiryDateOfBirth;
	private String enquiryEmail;
	private String enquiryGender;
	private Integer enquiryCibilScore;
	//@Enumerated
	private String enquiryStatus;

}
