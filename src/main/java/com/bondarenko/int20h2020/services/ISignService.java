package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;

public interface ISignService {
    JWT register(Person user);
    JWT authenticate(String email, String password);
    JWT refresh(String refreshToken, String fingerprint);
    boolean checkEmail(String email);
}
