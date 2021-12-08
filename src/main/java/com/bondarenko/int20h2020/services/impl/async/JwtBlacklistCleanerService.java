package com.bondarenko.int20h2020.services.impl.async;

import com.bondarenko.int20h2020.domain.entities.JwtBlacklist;
import com.bondarenko.int20h2020.repositories.JwtBlacklistRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class JwtBlacklistCleanerService {
    private final JwtBlacklistRepository jwtBlacklistRepository;

    public JwtBlacklistCleanerService(JwtBlacklistRepository jwtBlacklistRepository) {
        this.jwtBlacklistRepository = jwtBlacklistRepository;
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                this::execute,
                0,
                2,
                TimeUnit.HOURS
        );
    }

    private void execute() {
        Iterable<JwtBlacklist> jwtToDelete = jwtBlacklistRepository.findAllByExpiresAtBefore(LocalDateTime.now());
        jwtBlacklistRepository.deleteAll(jwtToDelete);
    }
}
