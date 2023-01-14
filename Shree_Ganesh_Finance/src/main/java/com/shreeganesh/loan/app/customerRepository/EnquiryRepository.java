package com.shreeganesh.loan.app.customerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeganesh.loan.app.customerEntities.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

}
