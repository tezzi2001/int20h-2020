package com.bondarenko.int20h2020.services.impl;

import com.bondarenko.int20h2020.domain.entities.DonorApplication;
import com.bondarenko.int20h2020.domain.entities.RecipientApplication;
import com.bondarenko.int20h2020.domain.dto.ApplicationInfoDto;
import com.bondarenko.int20h2020.repositories.DonorApplicationRepository;
import com.bondarenko.int20h2020.repositories.RecipientApplicationRepository;
import com.bondarenko.int20h2020.repositories.UserRepository;
import com.bondarenko.int20h2020.services.ApplicationService;
import com.bondarenko.int20h2020.util.DateUtils;
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
    public List<ApplicationInfoDto> findDonorApplications(Long userId, String rh, Integer groupNumber, String region) {
        return donorApplicationRepository
                .findAll()
                .stream()
                .filter(app -> userId == null || userId == 0 || userId.equals(app.getUser().getId()))
                .filter(app -> rh == null || rh.equals("") || rh.equals(app.getUser().getRh()))
                .filter(app -> groupNumber == null || groupNumber == 0 || groupNumber.equals(app.getUser().getGroupNumber()))
                .filter(app -> region == null || region.equals("") || region.equals(app.getUser().getRegion()))
                .map(app -> new ApplicationInfoDto(
                        app.getId(),
                        app.getUser().getBirthDay() == null ? null : DateUtils.getAge(app.getUser().getBirthDay()),
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
    public List<ApplicationInfoDto> findRecipientApplications(Long userId, String rh, Integer groupNumber, String region) {
        return recipientApplicationRepository
                .findAll()
                .stream()
                .filter(app -> userId == null || userId == 0 || userId.equals(app.getUser().getId()))
                .filter(app -> rh == null || rh.equals("") || rh.equals(app.getUser().getRh()))
                .filter(app -> groupNumber == null || groupNumber == 0 || groupNumber.equals(app.getUser().getGroupNumber()))
                .filter(app -> region == null || region.equals("") || region.equals(app.getUser().getRegion()))
                .map(app -> new ApplicationInfoDto(
                        app.getId(),
                        app.getUser().getBirthDay() == null ? null : DateUtils.getAge(app.getUser().getBirthDay()),
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
