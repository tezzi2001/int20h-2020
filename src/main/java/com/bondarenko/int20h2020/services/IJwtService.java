package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.entities.Person;

import java.io.IOException;
import java.util.Map;

public interface IJwtService {
    Map<String, String> getTokensOnAuth(String email, String password, String fingerprint);
    Map<String, String> refreshTokens(String oldRefreshToken, String fingerprint);
    Person getPersonFromToken(String accessToken) throws IOException;
}
