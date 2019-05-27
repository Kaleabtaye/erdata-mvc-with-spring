package com.Abogida.Erdata.repositories;

import org.springframework.data.repository.CrudRepository;

import com.Abogida.Erdata.security.User;

public interface UserRepository extends CrudRepository<User,String> {
	User findByUsername(String userName);
}
