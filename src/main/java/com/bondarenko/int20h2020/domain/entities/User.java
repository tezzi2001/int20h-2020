package com.bondarenko.int20h2020.domain.entities;

import com.bondarenko.int20h2020.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Integer age;
    private String name;
    private String region;
    private String sex;
    @Column(unique = true) private String phone;
    private Integer groupNumber;
    private String rh;
}
