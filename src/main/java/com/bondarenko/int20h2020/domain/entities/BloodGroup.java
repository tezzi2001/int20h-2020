package com.bondarenko.int20h2020.domain.entities;

import javax.persistence.Embeddable;

@Embeddable
public class BloodGroup {
    private int groupNumber;
    private char rh;
}
