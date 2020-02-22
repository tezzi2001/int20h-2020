package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;

public interface ISignService {
    public JWT register(Person user);
    public JWT authenticate(Person user);
    public JWT refresh(String refreshToken);
    public boolean checkEmail(String email);
}
