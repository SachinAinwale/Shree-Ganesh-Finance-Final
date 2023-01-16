package com.shreeganesh.loan.app.customerEntities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBankDetails {

@Id	
private Integer	customerBankId;
private Long customerBankAccountNo;
private String customerBankName;
private String	customerBankBranchName;
private String	customerBankIfscNo;
}
