package com.dev.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.jobportal.dto.RecruiterProfile;

public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Integer> {

}
