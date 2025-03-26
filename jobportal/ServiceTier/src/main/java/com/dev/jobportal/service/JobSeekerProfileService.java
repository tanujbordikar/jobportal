package com.dev.jobportal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.jobportal.dto.JobSeekerProfile;
import com.dev.jobportal.repository.JobSeekerProfileRepository;

@Service
public class JobSeekerProfileService {
	
	private final JobSeekerProfileRepository jobSeekerProfileRepository;
	
	@Autowired
	public JobSeekerProfileService(JobSeekerProfileRepository jobSeekerProfileRepository) {
		this.jobSeekerProfileRepository = jobSeekerProfileRepository;
	}
	
	public Optional<JobSeekerProfile> getOne(Integer id){
		return jobSeekerProfileRepository.findById(id);
	}

	public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
		return jobSeekerProfileRepository.save(jobSeekerProfile);
	}
}
