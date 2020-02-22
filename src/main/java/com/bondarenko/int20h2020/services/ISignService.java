package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.User;

public interface ISignService {
    public JWT register(User user);
    public JWT authenticate(User user);
    public JWT refresh(String refreshToken);
    public boolean checkEmail(String email);
}
