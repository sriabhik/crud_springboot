package com.User.security;


import com.User.entities.CustomerRecord;
import com.User.repository.CustomerRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerRecordRepo customerRecordRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomerRecord c = this.customerRecordRepo.findByEmail(username);
		return c;
	}
}
