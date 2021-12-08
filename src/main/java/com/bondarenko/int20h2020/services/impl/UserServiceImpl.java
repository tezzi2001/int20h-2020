package com.bondarenko.int20h2020.services.impl;

import com.auth0.jwt.JWT;
import com.bondarenko.int20h2020.domain.dto.UserDto;
import com.bondarenko.int20h2020.repositories.UserRepository;
import com.bondarenko.int20h2020.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUserInfo(String token) {
        String email = JWT.decode(token).getSubject();
        return new UserDto(userRepository
            .findByEmail(email)
            .orElseThrow(() -> new EntityNotFoundException("User not found by email " + email)));
    }
}
