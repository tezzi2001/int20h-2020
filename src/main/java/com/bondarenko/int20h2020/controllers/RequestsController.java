package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.domain.dto.ApplicationInfoDto;
import com.bondarenko.int20h2020.domain.dto.UserDto;
import com.bondarenko.int20h2020.services.ApplicationService;
import com.bondarenko.int20h2020.services.RegionService;
import com.bondarenko.int20h2020.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class RequestsController {
    private final UserService userService;
    private final ApplicationService applicationService;
    private final RegionService regionService;

    @GetMapping("/findDonorApplications")
    public List<ApplicationInfoDto> findDonorApplications(@RequestParam Long userId, @RequestParam String rh, @RequestParam Integer groupNumber, @RequestParam String region) {
        return applicationService.findDonorApplications(userId, rh, groupNumber, region);
    }

    @GetMapping("/findRecipientApplications")
    public List<ApplicationInfoDto> findRecipientApplications(@RequestParam Long userId, @RequestParam String rh, @RequestParam Integer groupNumber, @RequestParam String region) {
        return applicationService.findRecipientApplications(userId, rh, groupNumber, region);
    }

    @PostMapping("/addDonorApplication")
    public void addDonorApplication(@RequestBody ApplicationInfoDto applicationInfoDto) {
        applicationService.addDonorApplication(applicationInfoDto.getId(), applicationInfoDto.getDateTime());
    }

    @PostMapping("/addRecipientApplication")
    public void addRecipientApplication(@RequestBody ApplicationInfoDto applicationInfoDto) {
        applicationService.addRecipientApplication(applicationInfoDto.getId(), applicationInfoDto.getDateTime());
    }

    @GetMapping("/user/{id}")
    public UserDto fetchUser(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/regions")
    public List<String> fetchRegions() {
        return regionService.getAllRegions();
    }
}
