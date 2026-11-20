package com.tchaikop.sbb.entity;

public enum UserRole {
	
	//권한 이름 목록 설정
	
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	private final String value;

    UserRole(String value) {
        this.value = value;
    }

}
