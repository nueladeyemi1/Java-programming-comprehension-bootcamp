package com.nueladeyemi.syllogi.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewRepository extends JpaRepository {
    List<Review> findByCompanyId(Long companyId);
}
