package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.dto.UserDto;

public interface UserService {
    UserDto getUserInfo(Long id);
    void saveUser(UserDto userDto);
}
