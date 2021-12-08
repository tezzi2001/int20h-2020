package com.bondarenko.int20h2020.services.impl.async;

import com.bondarenko.int20h2020.domain.entities.DonorApplication;
import com.bondarenko.int20h2020.domain.entities.JwtBlacklist;
import com.bondarenko.int20h2020.domain.entities.RecipientApplication;
import com.bondarenko.int20h2020.repositories.DonorApplicationRepository;
import com.bondarenko.int20h2020.repositories.RecipientApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ApplicationCleanerService {
    private final DonorApplicationRepository donorApplicationRepository;
    private final RecipientApplicationRepository recipientApplicationRepository;

    public ApplicationCleanerService(DonorApplicationRepository donorApplicationRepository, RecipientApplicationRepository recipientApplicationRepository) {
        this.donorApplicationRepository = donorApplicationRepository;
        this.recipientApplicationRepository = recipientApplicationRepository;
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                this::executeDonorApps,
                0,
                2,
                TimeUnit.HOURS
        );
        scheduledExecutorService.scheduleWithFixedDelay(
                this::executeRecipientApps,
                0,
                2,
                TimeUnit.HOURS
        );
    }

    private void executeDonorApps() {
        Iterable<DonorApplication> appsToDelete = donorApplicationRepository.findAllByExpiresAtBefore(new Date());
        donorApplicationRepository.deleteAll(appsToDelete);
    }

    private void executeRecipientApps() {
        Iterable<RecipientApplication> appsToDelete = recipientApplicationRepository.findAllByDateBefore(new Date());
        recipientApplicationRepository.deleteAll(appsToDelete);
    }
}
