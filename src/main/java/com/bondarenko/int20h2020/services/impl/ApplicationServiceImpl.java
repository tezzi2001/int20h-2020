package com.bondarenko.int20h2020.services.impl;

import com.bondarenko.int20h2020.domain.entities.DonorApplication;
import com.bondarenko.int20h2020.domain.entities.RecipientApplication;
import com.bondarenko.int20h2020.domain.dto.ApplicationInfoDto;
import com.bondarenko.int20h2020.repositories.DonorApplicationRepository;
import com.bondarenko.int20h2020.repositories.RecipientApplicationRepository;
import com.bondarenko.int20h2020.repositories.UserRepository;
import com.bondarenko.int20h2020.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private DonorApplicationRepository donorApplicationRepository;
    private RecipientApplicationRepository recipientApplicationRepository;
    private UserRepository userRepository;

    @Override
    public List<ApplicationInfoDto> findDonorApplications() {
        return donorApplicationRepository
                .findAll()
                .stream()
                .map(app -> new ApplicationInfoDto(
                        app.getId(),
                        app.getUser().getAge(),
                        app.getUser().getEmail(),
                        app.getUser().getGroupNumber(),
                        app.getUser().getName(),
                        app.getUser().getRegion(),
                        app.getUser().getRh(),
                        app.getUser().getSex(),
                        app.getUser().getPhone(),
                        app.getExpiresAt()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationInfoDto> findRecipientApplications() {
        return recipientApplicationRepository
                .findAll()
                .stream()
                .map(app -> new ApplicationInfoDto(
                        app.getId(),
                        app.getUser().getAge(),
                        app.getUser().getEmail(),
                        app.getUser().getGroupNumber(),
                        app.getUser().getName(),
                        app.getUser().getRegion(),
                        app.getUser().getRh(),
                        app.getUser().getSex(),
                        app.getUser().getPhone(),
                        app.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public void addDonorApplication(Long id, Date expiresAt) {
        donorApplicationRepository.save(new DonorApplication(expiresAt, userRepository.findById(id).get()));
    }

    @Override
    public void addRecipientApplication(Long id, Date date) {
        recipientApplicationRepository.save(new RecipientApplication(date, userRepository.findById(id).get()));
    }
}
