package com.bondarenko.int20h2020.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String email;
    private String password;
    private int age;
    private String name;
    private String region;
    private String sex;
    private BloodGroup bloodGroup;
}