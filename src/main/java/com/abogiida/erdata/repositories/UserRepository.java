package com.abogiida.erdata.repositories;

import org.springframework.data.repository.CrudRepository;

import com.abogiida.erdata.security.User;

public interface UserRepository extends CrudRepository<User,Long> {
	User findByUsername(String userName);
}
