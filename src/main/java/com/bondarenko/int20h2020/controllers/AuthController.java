package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.domain.dto.UserDto;
import com.bondarenko.int20h2020.services.AuthService;
import com.bondarenko.int20h2020.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.bondarenko.int20h2020.constants.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        authService.saveDto(userDto);
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("authorization") String authorization) {
        if (!authorization.contains(TOKEN_PREFIX)) {
            return;
        }
        String token = authorization.replace(TOKEN_PREFIX, "");
        authService.logout(token);
    }

    @GetMapping("/fetchUser")
    public UserDto fetchUser(@RequestHeader("authorization") String authorization) {
        if (!authorization.contains(TOKEN_PREFIX)) {
            return null;
        }
        String token = authorization.replace(TOKEN_PREFIX, "");
        return userService.getUserInfo(token);
    }
}
