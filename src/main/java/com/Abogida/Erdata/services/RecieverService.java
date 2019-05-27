package com.Abogida.Erdata.services;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.Abogida.Erdata.security.Reciever;
import com.Abogida.Erdata.security.Donor;
import com.Abogida.Erdata.services.UserService;

public interface RecieverService {
	Reciever findUserByUsername(String username);
	void saveUser(Reciever reciever);
}
