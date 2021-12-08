package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.JwtBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface JwtBlacklistRepository extends JpaRepository<JwtBlacklist, Long> {
    boolean existsBySignature(String signature);

    Iterable<JwtBlacklist> findAllByExpiresAtBefore(LocalDateTime currentDateTime);
}
