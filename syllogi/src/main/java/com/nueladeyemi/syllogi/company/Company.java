package com.nueladeyemi.syllogi.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nueladeyemi.syllogi.job.Job;
import com.nueladeyemi.syllogi.reviews.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


    @OneToMany(mappedBy = "company")
    private List<Review> review;

    public Company() {
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public Company(Long id, String name, String address, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
