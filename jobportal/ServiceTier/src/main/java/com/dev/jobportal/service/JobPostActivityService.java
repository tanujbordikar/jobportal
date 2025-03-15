package com.dev.jobportal.service;

import org.springframework.stereotype.Service;

import com.dev.jobportal.dto.JobPostActivity;
import com.dev.jobportal.repository.JobPostActivityRepository;

@Service
public class JobPostActivityService {
	
	private final JobPostActivityRepository jobPostActivityRepository;
	
	public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
		this.jobPostActivityRepository = jobPostActivityRepository;
	}
	
	public JobPostActivity addNew(JobPostActivity jobPostActivity) {
		return jobPostActivityRepository.save(jobPostActivity);
	}
}
