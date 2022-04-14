package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.dto.ApplicationInfoDto;

import java.util.Date;
import java.util.List;

public interface ApplicationService {

    List<ApplicationInfoDto> findDonorApplications(Long userId, String rh, Integer groupNumber, String region);

    List<ApplicationInfoDto> findRecipientApplications(Long userId, String rh, Integer groupNumber, String region);

    void addDonorApplication(Long id, Date expiresAt);

    void addRecipientApplication(Long id, Date date);
}
