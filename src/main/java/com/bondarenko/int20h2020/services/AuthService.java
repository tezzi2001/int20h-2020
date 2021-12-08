package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    void saveDto(UserDto userDto);

    void logout(String token);

    boolean canAuthorize(String token);
}
