package com.abogiida.erdata.services;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abogiida.erdata.repositories.RoleRepository;
import com.abogiida.erdata.repositories.UserRepository;
import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.security.Role;
import com.abogiida.erdata.security.User;
@Service
public class UserServiceImpl implements UserService {


	private UserRepository userRepository;
    private RoleRepository roleRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    
    public User findUserByUsername(String userName) {
    	return userRepository.findByUsername(userName);
    }
    

    @Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(userName);
		
		if(user == null) {
			throw new UsernameNotFoundException("Donor '" + userName + "' not found");
		}
		 return new org.springframework.security.core.userdetails.User(user.getUsername(),
	                user.getPassword(),
	                mapRolesToAuthorities(user.getRoles()));
		
	}
	 private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getRole()))
	                .collect(Collectors.toList());
	    }

	@Override
	public void saveUser(User user,String role) {
        user.setEnabled(1);
        Role userRole = roleRepository.findByRole(role);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);		
	}


}
