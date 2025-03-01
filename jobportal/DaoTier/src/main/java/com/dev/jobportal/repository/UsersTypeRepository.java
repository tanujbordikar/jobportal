package com.dev.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.jobportal.dto.UsersType;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer>{
	
}
