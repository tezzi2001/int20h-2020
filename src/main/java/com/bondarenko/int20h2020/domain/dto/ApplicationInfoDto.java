package com.bondarenko.int20h2020.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApplicationInfoDto {
    private Long id;
    private Integer age;
    private String email;
    private Integer bloodGroup;
    private String name;
    private String region;
    private String rh;
    private String sex;
    private String phone;
    private Date dateTime;
}
