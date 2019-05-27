package com.Abogida.Erdata.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Abogida.Erdata.security.Donor;
import com.Abogida.Erdata.services.UserService;

public interface DonorService{

	Donor findUserByUsername(String username);
	void saveUser(Donor user);
}
