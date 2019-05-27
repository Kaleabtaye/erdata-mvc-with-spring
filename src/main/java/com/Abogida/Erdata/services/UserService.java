package com.Abogida.Erdata.services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.Abogida.Erdata.security.User;

public interface UserService extends UserDetailsService {
	User findUserByUsername(String username);
	void saveUser(User user,String role);

}
