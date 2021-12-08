package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.RecipientApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface RecipientApplicationRepository extends JpaRepository<RecipientApplication, Integer> {
    Iterable<RecipientApplication> findAllByDateBefore(Date currentDate);

}
