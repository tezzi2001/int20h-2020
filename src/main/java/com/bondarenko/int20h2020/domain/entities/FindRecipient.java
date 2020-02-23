package com.bondarenko.int20h2020.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FindRecipient {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_email")
    private Person person;
    @Column(columnDefinition = "varchar not null unique")
    private String phone;

    public FindRecipient(Person person, String phone) {
        this.person = person;
        this.phone = phone;
    }
}
