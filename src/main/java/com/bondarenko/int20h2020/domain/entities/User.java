package com.bondarenko.int20h2020.domain.entities;

import com.bondarenko.int20h2020.domain.dto.UserDto;
import com.bondarenko.int20h2020.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(unique = true) private String email;
    private String password;
    @Enumerated(EnumType.STRING) private Role role;
    private String name;
    private String region;
    private String sex;
    @Column(unique = true) private String phone;
    private Integer groupNumber;
    private String rh;
    private Date birthDay;
    private String diseases;

    public User(UserDto userDto, User user) {
        this.id = userDto.getId() == null ? user.getId() : userDto.getId();
        this.email = userDto.getEmail() == null ? user.getEmail() : userDto.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.name = userDto.getName() == null ? user.getName() : userDto.getName();
        this.region = userDto.getRegion() == null ? user.getRegion() : userDto.getRegion();
        this.sex = userDto.getSex() == null ? user.getSex() : userDto.getSex();
        this.phone = userDto.getPhone() == null ? user.getPhone() : userDto.getPhone();
        this.groupNumber = userDto.getGroupNumber() == null ? user.getGroupNumber() : userDto.getGroupNumber();
        this.rh = userDto.getRh() == null ? user.getRh() : userDto.getRh();
        this.birthDay = userDto.getBirthDay() == null ? user.getBirthDay() : userDto.getBirthDay();
        this.diseases = userDto.getDiseases() == null ? user.getDiseases() : userDto.getDiseases();
    }
}
