package com.Abogida.Erdata.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Abogida.Erdata.security.Donor;

public interface DonorRepository  extends CrudRepository<Donor,String> {
	Donor findByUsername(String userName);
	
}	
