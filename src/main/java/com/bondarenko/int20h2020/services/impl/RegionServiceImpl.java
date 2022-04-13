package com.bondarenko.int20h2020.services.impl;

import com.bondarenko.int20h2020.domain.entities.Region;
import com.bondarenko.int20h2020.repositories.RegionRepository;
import com.bondarenko.int20h2020.services.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    @Override
    public List<String> getAllRegions() {
        return regionRepository.findAll().stream()
                .map(Region::getName)
                .collect(Collectors.toList());
    }
}
