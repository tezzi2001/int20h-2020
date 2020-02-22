package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;

import java.io.IOException;

public interface IJwtService {
    JWT getTokensOnAuth(String email, String password, String fingerprint);
    JWT refreshTokens(String oldRefreshToken, String fingerprint);
    Person getPersonFromToken(String accessToken) throws IOException;
}
