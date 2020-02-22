package com.bondarenko.int20h2020.domain.output;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BriefDescription {
    private String name;
    private int bloodGroup;
    private char rh;
    private String region;
}
