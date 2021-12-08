package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.DonorApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DonorApplicationRepository extends JpaRepository<DonorApplication, Integer> {
    Iterable<DonorApplication> findAllByExpiresAtBefore(Date currentDate);
}
