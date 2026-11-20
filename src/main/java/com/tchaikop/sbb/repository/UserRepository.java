package com.tchaikop.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tchaikop.sbb.entity.Siteuser;

public interface UserRepository extends JpaRepository<Siteuser,Long>{
	
	Siteuser findByUsername(String username);

}
