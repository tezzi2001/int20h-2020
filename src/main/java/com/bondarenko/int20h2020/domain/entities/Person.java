package com.bondarenko.int20h2020.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String email;
    private String password;
    private int birthDate;
    private String name;
    private String region;
    private String sex;
    private BloodGroup bloodGroup;
    @ElementCollection
    private List<String> subscriptions = new ArrayList<>();

    public void addSub(String email) {
        if (subscriptions == null) subscriptions = new ArrayList<>();
        subscriptions.add(email);
    }

    public void removeSub(String email) {
        if (subscriptions == null) return;
        subscriptions.remove(email);
    }

    public String[] getSubAsArray() {
        if (subscriptions == null) subscriptions = new ArrayList<>();
        return subscriptions.toArray(new String[subscriptions.size()]);
    }
}