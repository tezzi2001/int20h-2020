package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.domain.dto.ApplicationInfoDto;
import com.bondarenko.int20h2020.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class RequestsController {
    private ApplicationService applicationService;

    @GetMapping("/findDonorApplications")
    public List<ApplicationInfoDto> findDonorApplications() {
        return applicationService.findDonorApplications();
    }

    @GetMapping("/findRecipientApplications")
    public List<ApplicationInfoDto> findRecipientApplications() {
        return applicationService.findRecipientApplications();
    }

    @PostMapping("/addDonorApplication")
    public void addDonorApplication(@RequestBody ApplicationInfoDto applicationInfoDto) {
        applicationService.addDonorApplication(applicationInfoDto.getId(), applicationInfoDto.getDateTime());
    }

    @PostMapping("/addRecipientApplication")
    public void addRecipientApplication(@RequestBody ApplicationInfoDto applicationInfoDto) {
        applicationService.addRecipientApplication(applicationInfoDto.getId(), applicationInfoDto.getDateTime());
    }
}
