package com.bondarenko.int20h2020.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id
    private String fingerprint;
    @OneToOne
    @JoinColumn(name = "person_email")
    private Person person;
    private String refreshToken;
    private Date expiresAt;
    private Date createdAt;
    private Date updatedAt;
}