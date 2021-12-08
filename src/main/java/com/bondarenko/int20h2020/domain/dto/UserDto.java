package com.bondarenko.int20h2020.domain.dto;

import com.bondarenko.int20h2020.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String email;
    private String password;

    private int age;
    private String name;
    private String region;
    private String sex;
    private String phone;
    private int groupNumber;
    private String rh;

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
    }
}
