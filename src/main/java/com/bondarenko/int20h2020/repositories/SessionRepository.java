package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
    Optional<Session> getSessionByRefreshToken(String refreshToken);
    void deleteSessionByRefreshToken(String refreshToken);
    boolean existsSessionByFingerprint(String fingerprint);
    void deleteSessionByFingerprint(String fingerprint);
}
