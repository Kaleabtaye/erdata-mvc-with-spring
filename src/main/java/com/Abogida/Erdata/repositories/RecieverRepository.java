package com.Abogida.Erdata.repositories;

import org.springframework.data.repository.CrudRepository;

import com.Abogida.Erdata.security.Reciever;

public interface RecieverRepository extends CrudRepository<Reciever,String> {
	Reciever findByUsername(String userName);
}
