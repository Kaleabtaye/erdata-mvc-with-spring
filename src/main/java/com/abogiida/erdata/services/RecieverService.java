package com.abogiida.erdata.services;

import java.util.Optional;

import com.abogiida.erdata.domains.FreeAid;
import com.abogiida.erdata.security.Reciever;

public interface RecieverService {
	Reciever findUserByUsername(String username);
	void saveUser(Reciever reciever);
	Iterable<Reciever> findAll();
	Optional<Reciever> findById(Long id);

}
