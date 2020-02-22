package com.bondarenko.int20h2020.domain.output;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FullDescription {
    private int age;
    private String email;
    private int bloodGroup;
    private String name;
    private String region;
    private char rh;
    private String sex;
    private int phone;
}
