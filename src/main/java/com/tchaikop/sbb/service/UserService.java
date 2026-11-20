package com.tchaikop.sbb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tchaikop.sbb.entity.Siteuser;
import com.tchaikop.sbb.entity.UserRole;
import com.tchaikop.sbb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	//회원가입 메서드
	public Siteuser create(String username,String password, String email) {
		
		Siteuser siteuser = new Siteuser();
		siteuser.setUsername(username);
		siteuser.setEmail(email);
		siteuser.setPassword(passwordEncoder.encode(password)); // 비밀번호가 평문 그대로 db에 저장 -
		// 비밀번호를 암ㅎ화 한 후 저장해야 한다
		
		
		if(username.equals("admin")) {
			siteuser.setRole(UserRole.ADMIN);
		}else
		siteuser.setRole(UserRole.USER);  //기본회원 권한은 일반회원
		
		
		userRepository.save(siteuser);
		
		return siteuser;
		
	}

}
