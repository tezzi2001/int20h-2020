package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignService implements ISignService {
    private UserRepository userRepository;
    private IJwtService jwtService;

    @Override
    public JWT register(Person user) {
        userRepository.save(user);
        return jwtService.getTokensOnAuth(user.getEmail(), user.getPassword(), null);
    }

    @Override
    public JWT authenticate(String email, String password) {
        return null;
    }

    @Override
    public JWT refresh(String refreshToken, String fingerprint) {
        return null;
    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }
}
