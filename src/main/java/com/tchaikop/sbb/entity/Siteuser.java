package com.tchaikop.sbb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Siteuser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ai 옵션 설정
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	@Enumerated(EnumType.ORDINAL)  //1--> admin  2 ->user
	
	//권한 설정  role->enum 타입이므로 Admin Ehsms User만 가질 수 있음
	private UserRole role;
}
