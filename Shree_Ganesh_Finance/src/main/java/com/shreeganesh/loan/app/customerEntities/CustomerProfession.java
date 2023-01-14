package com.shreeganesh.loan.app.customerEntities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProfession {
	
	 @Id
     private Integer professionId;
	 private String professionType;
	 private Double DouprofessionMonthlyIncome;
	 private String professionDesignation;

}
