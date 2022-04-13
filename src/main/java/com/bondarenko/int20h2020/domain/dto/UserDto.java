package com.bondarenko.int20h2020.domain.dto;

import com.bondarenko.int20h2020.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String email;
    private String password;

    private Integer age;
    private String name;
    private String region;
    private String sex;
    private String phone;
    private Integer groupNumber;
    private String rh;
    private Date birthDay;
    private String diseases;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.age = user.getAge();

        this.name = user.getName();
        this.region = user.getRegion();
        this.sex = user.getSex();
        this.phone = user.getPhone();
        this.groupNumber = user.getGroupNumber();
        this.rh = user.getRh();
        this.birthDay = user.getBirthDay();
        this.diseases = user.getDiseases();
    }
}
