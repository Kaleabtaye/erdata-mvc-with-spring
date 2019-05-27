package com.abogiida.erdata.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.services.UserService;

public interface DonorService{

	Donor findUserByUsername(String username);
	void saveUser(Donor user);
}
