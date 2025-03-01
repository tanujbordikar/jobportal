package com.dev.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.jobportal.dto.JobSeekerProfile;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {

}
