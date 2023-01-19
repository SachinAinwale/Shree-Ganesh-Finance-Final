package com.shreeganesh.loan.app.customerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreeganesh.loan.app.customerEntities.SanctionLetter;

public interface SanctionLetterRepository extends JpaRepository<SanctionLetter, Integer>{

}
