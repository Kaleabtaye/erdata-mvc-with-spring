package com.Abogida.Erdata.services;

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

import com.Abogida.Erdata.repositories.RecieverRepository;
import com.Abogida.Erdata.repositories.RoleRepository;
import com.Abogida.Erdata.security.Role;
import com.Abogida.Erdata.security.User;
import com.Abogida.Erdata.security.Donor;
import com.Abogida.Erdata.security.Reciever;

@Service
public class RecieverServiceImpl implements RecieverService {
	
	private RecieverRepository recieverRepository;
	private RoleRepository roleRepository;
	 private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public RecieverServiceImpl(RecieverRepository recieverRepository,
			  RoleRepository roleRepository,UserService userService,
              BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.recieverRepository = recieverRepository;
		this.roleRepository = roleRepository;
		this.userService = userService;  
	    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}
	
	public Reciever findUserByUsername(String userName) {
	    	return recieverRepository.findByUsername(userName);
	}
	    
	public void saveUser(Reciever reciever) {
	    	reciever.setPassword(bCryptPasswordEncoder.encode(reciever.getPassword()));
	    	reciever.setEnabled(1);
	        Role recieverRole = roleRepository.findByRole("RECIEVER");
	        reciever.setRoles(new HashSet<Role>(Arrays.asList(recieverRole)));
	        recieverRepository.save(reciever);
	        User user = new User();
	        user.setUsername(reciever.getUsername());
			user.setPassword(reciever.getPassword());
	        userService.saveUser(user, "RECIEVER");
	    }
/*
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			
			Reciever reciever = recieverRepository.findByUsername(userName);
			
			if(reciever == null) {
				throw new UsernameNotFoundException("Donor '" + userName + "' not found");
			}
			 return new org.springframework.security.core.userdetails.User(reciever.getUsername(),
					 reciever.getPassword(),
		                mapRolesToAuthorities(reciever.getRoles()));
			
		}
		*/
		private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		        return roles.stream()
		                .map(role -> new SimpleGrantedAuthority(role.getRole()))
		                .collect(Collectors.toList());
		    }

}


