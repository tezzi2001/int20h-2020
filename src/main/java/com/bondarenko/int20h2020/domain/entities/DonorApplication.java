package com.bondarenko.int20h2020.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class DonorApplication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne @JoinColumn(name = "user_id") private User user;
    private Boolean isActive;
    private Date expiresAt;

    public DonorApplication(Date expiresAt, User user) {
        this.expiresAt = expiresAt;
        this.user = user;
        this.isActive = true;
    }
}
