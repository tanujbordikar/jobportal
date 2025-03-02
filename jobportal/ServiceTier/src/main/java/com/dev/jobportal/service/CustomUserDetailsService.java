package com.dev.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.jobportal.dto.Users;
import com.dev.jobportal.repository.UsersRepository;
import com.dev.jobportal.util.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UsersRepository usersRepository;
	
	@Autowired
	public CustomUserDetailsService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = usersRepository.findByEmail(username).orElseThrow(() -> (new UsernameNotFoundException("User could not found!")));
		return new CustomUserDetails(user);
	}

}
