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
public class AllDocuments {
	
	@Id
   private Integer documentID;
   private byte[] addressProof;
   private byte[] panCard;
   private byte[] incomeProof;
   private byte[] addharCard;
   private byte[] photo;
   private byte[] signature;
   private byte[] thumb;
   private byte[] bankPassbook;
   private byte[] drivingLicense;

}
