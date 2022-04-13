package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
