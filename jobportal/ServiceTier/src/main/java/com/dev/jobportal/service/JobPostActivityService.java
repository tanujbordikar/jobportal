package com.dev.jobportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.jobportal.dto.IRecruiterJobs;
import com.dev.jobportal.dto.JobCompany;
import com.dev.jobportal.dto.JobLocation;
import com.dev.jobportal.dto.JobPostActivity;
import com.dev.jobportal.dto.RecruiterJobsDto;
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
	
	public List<RecruiterJobsDto> getRecruiterJobs(int recruiter) {

        List<IRecruiterJobs> recruiterJobsDtos = jobPostActivityRepository.getRecruiterJobs(recruiter);

        List<RecruiterJobsDto> recruiterJobsDtoList = new ArrayList<>();

        for (IRecruiterJobs rec : recruiterJobsDtos) {
            JobLocation loc = new JobLocation(rec.getLocationId(), rec.getCity(), rec.getState(), rec.getCountry());
            JobCompany comp = new JobCompany(rec.getCompanyId(), rec.getName(), "");
            recruiterJobsDtoList.add(new RecruiterJobsDto(rec.getTotalCandidates(), rec.getJob_post_id(),
                    rec.getJob_title(), loc, comp));
        }
        return recruiterJobsDtoList;

    }

	public JobPostActivity getOne(int id) {

        return jobPostActivityRepository.findById(id).orElseThrow(()->new RuntimeException("Job not found"));
    }
}
