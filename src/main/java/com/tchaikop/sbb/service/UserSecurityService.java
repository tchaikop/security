package com.tchaikop.sbb.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tchaikop.sbb.entity.Siteuser;
import com.tchaikop.sbb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	
	
		
	Siteuser user = userRepository.findByUsername(username);
	
	if(user == null) {
		
		throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
	}
						
			
						return User.builder()
					        .username(user.getUsername())
					        .password(user.getPassword())
					        .roles(user.getRole().name())  //.authorities.(user.getRole().getValue())  사용자의 권한(admin, user)
					        .build();
					
					
	}

}
