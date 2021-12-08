package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.dto.ApplicationInfoDto;

import java.util.Date;
import java.util.List;

public interface ApplicationService {

    List<ApplicationInfoDto> findDonorApplications();

    List<ApplicationInfoDto> findRecipientApplications();

    void addDonorApplication(Long id, Date expiresAt);

    void addRecipientApplication(Long id, Date date);
}
