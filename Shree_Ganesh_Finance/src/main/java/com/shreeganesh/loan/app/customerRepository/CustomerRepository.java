package com.shreeganesh.loan.app.customerRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreeganesh.loan.app.customerEntities.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer> {

	 public Optional<CustomerDetails> findAllByCustomerStatus(String valueOf);

	

}
