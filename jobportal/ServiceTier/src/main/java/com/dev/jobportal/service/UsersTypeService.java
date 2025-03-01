package com.dev.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.jobportal.dto.UsersType;
import com.dev.jobportal.repository.UsersTypeRepository;

import java.util.List;

@Service
public class UsersTypeService {

    private final UsersTypeRepository usersTypeRepository;
    
    @Autowired
    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll() {
        return usersTypeRepository.findAll();
    }
}