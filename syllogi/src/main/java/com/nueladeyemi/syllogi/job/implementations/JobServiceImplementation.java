package com.nueladeyemi.syllogi.job.implementations;

import com.nueladeyemi.syllogi.job.Job;
import com.nueladeyemi.syllogi.job.JobRepository;
import com.nueladeyemi.syllogi.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService {
//  private List<Job> jobs = new ArrayList<>();
  private Long id;

    JobRepository jobRepository;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJob(Long id) {
        try {
        jobRepository.deleteById(id);
        return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()) {
                Job specificJob = jobOptional.get();
                specificJob.setTitle(job.getTitle());
                specificJob.setDescription(job.getDescription());
                specificJob.setLocation(job.getLocation());
                specificJob.setMinSalary(job.getMinSalary());
                specificJob.setMinSalary(job.getMaxSalary());

                return true;
            }

        return false;
    }

}
