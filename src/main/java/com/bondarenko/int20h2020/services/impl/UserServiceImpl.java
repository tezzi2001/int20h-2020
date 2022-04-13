package com.bondarenko.int20h2020.services.impl;

import com.bondarenko.int20h2020.domain.dto.UserDto;
import com.bondarenko.int20h2020.domain.entities.User;
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
    public UserDto getUserInfo(Long id) {
        return new UserDto(userRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found by id " + id)));
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = userRepository
                .findById(userDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found by id " + userDto.getId()));
        userRepository.save(new User(userDto, user));
    }
}
