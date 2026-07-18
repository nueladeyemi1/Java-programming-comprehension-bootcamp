package com.nueladeyemi.syllogi.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll () {
        return jobService.findAll();
    }

    @PostMapping
    public String createJob (@RequestBody Job job) {
        jobService.createJob(job);
        return "Job added successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findOne (@PathVariable Long id) {
        Job job = jobService.getJobById(id);

    if (job != null) return new ResponseEntity<>(job, HttpStatus.OK);

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> findOneAndDelete(@PathVariable Long id) {
        //Find the specific job
        Job job = jobService.getJobById(id);
        if (job != null) {
           boolean deleted = jobService.deleteJob(id);
           if (deleted)
               return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob (@PathVariable Long id, @RequestBody Job jobData) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            boolean updated = jobService.updateJob(id, jobData);
            if (updated)
                return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
