package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
    Optional<Session> getSessionByRefreshToken(String refreshToken);
    @Transactional
    void deleteSessionByRefreshToken(String refreshToken);
    boolean existsSessionByFingerprint(String fingerprint);
    @Transactional
    void deleteSessionByFingerprint(String fingerprint);
}
