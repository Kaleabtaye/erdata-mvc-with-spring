package com.abogiida.erdata.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abogiida.erdata.security.Donor;

public interface DonorRepository  extends CrudRepository<Donor,Long> {
	Donor findByUsername(String userName);
	
}	
