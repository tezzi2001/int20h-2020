package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;

public interface ISignService {
    JWT register(Person user, String fingerprint);
    JWT authenticate(String email, String password, String fingerprint);
    JWT refresh(String refreshToken, String fingerprint);
    boolean checkEmail(String email);
}
