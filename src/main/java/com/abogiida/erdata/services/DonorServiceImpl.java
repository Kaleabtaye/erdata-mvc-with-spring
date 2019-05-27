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

import com.abogiida.erdata.repositories.DonorRepository;
import com.abogiida.erdata.repositories.RoleRepository;
import com.abogiida.erdata.repositories.UserRepository;
import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.security.Role;
import com.abogiida.erdata.security.User;

@Service
public class DonorServiceImpl implements DonorService{
	
	private DonorRepository donorRepository;
    private RoleRepository roleRepository;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DonorServiceImpl(DonorRepository donorRepository,
                       RoleRepository roleRepository,UserService userService,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.donorRepository = donorRepository;
        this.userService = userService;  	
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Donor findUserByUsername(String userName) {
    	return donorRepository.findByUsername(userName);
    }
    
    public void saveUser(Donor donor) {
        donor.setPassword(bCryptPasswordEncoder.encode(donor.getPassword()));
        donor.setEnabled(1);
        Role userRole = roleRepository.findByRole("DONOR");
        donor.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        donorRepository.save(donor);
        User user = new User();
        user.setUsername(donor.getUsername());
		user.setPassword(donor.getPassword());
        userService.saveUser(user, "DONOR");

    }
/*
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Donor user = userRepository.findByUsername(userName);
		
		if(user == null) {
			throw new UsernameNotFoundException("Donor '" + userName + "' not found");
		}
		 return new org.springframework.security.core.userdetails.User(user.getUsername(),
	                user.getPassword(),
	                mapRolesToAuthorities(user.getRoles()));
		
	}
	*/
	 private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getRole()))
	                .collect(Collectors.toList());
	    }
}
