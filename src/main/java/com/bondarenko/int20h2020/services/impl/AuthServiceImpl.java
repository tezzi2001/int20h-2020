package com.bondarenko.int20h2020.services.impl;

import com.auth0.jwt.JWT;
import com.bondarenko.int20h2020.domain.entities.JwtBlacklist;
import com.bondarenko.int20h2020.security.Role;
import com.bondarenko.int20h2020.domain.entities.User;
import com.bondarenko.int20h2020.domain.dto.UserDto;
import com.bondarenko.int20h2020.repositories.JwtBlacklistRepository;
import com.bondarenko.int20h2020.repositories.UserRepository;
import com.bondarenko.int20h2020.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

import static com.bondarenko.int20h2020.util.DateUtils.dateToLocalDate;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtBlacklistRepository jwtBlacklistRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void saveDto(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (!optionalUser.isPresent()) {
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());

            User user = User.builder()
                    .email(userDto.getEmail())
                    .password(encodedPassword)
                    .role(Role.USER)
                    .name(userDto.getName())
                    .region(userDto.getRegion())
                    .groupNumber(userDto.getGroupNumber())
                    .rh(userDto.getRh())
                    .sex(userDto.getSex())
                    .phone(userDto.getPhone())
                    .age(userDto.getAge())
                    .build();
            userRepository.save(user);
        }
    }

    @Override
    public void logout(String token) {
        String signature = JWT.decode(token).getSignature();
        Date expiresAt = JWT.decode(token).getExpiresAt();

        JwtBlacklist jwtBlacklist = JwtBlacklist.builder()
                .signature(signature)
                .expiresAt(dateToLocalDate(expiresAt))
                .build();
        jwtBlacklistRepository.save(jwtBlacklist);
    }

    @Override
    public boolean canAuthorize(String token) {
        String signature = JWT.decode(token).getSignature();
        return !jwtBlacklistRepository.existsBySignature(signature);
    }
}
