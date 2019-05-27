package com.abogiida.erdata.services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.abogiida.erdata.domains.FreeAid;
import com.abogiida.erdata.security.User;

public interface UserService extends UserDetailsService {
	User findUserByUsername(String username);
	void saveUser(User user,String role);

}
