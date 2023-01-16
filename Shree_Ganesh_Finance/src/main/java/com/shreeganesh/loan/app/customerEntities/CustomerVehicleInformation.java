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
public class CustomerVehicleInformation {
@Id	
private Integer	customerVehicleId;
private String	customerVehicleModel;
private String	customerVehicleChasisNo;
private String	customerVehicleNo;
private String	customerVehicleRcNo;

}
