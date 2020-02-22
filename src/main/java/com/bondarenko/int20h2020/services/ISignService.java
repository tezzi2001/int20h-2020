package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;

import javax.transaction.Transactional;

public interface ISignService {
    @Transactional
    JWT register(Person user, String fingerprint);
    @Transactional
    JWT authenticate(String email, String password, String fingerprint);
    @Transactional
    JWT refresh(String refreshToken, String fingerprint);
    boolean checkEmail(String email);
}
