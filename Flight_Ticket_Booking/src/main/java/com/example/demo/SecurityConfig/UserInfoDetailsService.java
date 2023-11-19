package com.example.demo.SecurityConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepo;
import com.example.demo.Tables.UserTable;


@Component
public class UserInfoDetailsService implements UserDetailsService {

	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserTable> userinfo = repo.findByName(username);
		
		return userinfo.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));

	}

}
