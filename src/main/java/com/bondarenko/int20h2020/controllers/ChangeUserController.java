package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.services.ISignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class ChangeUserController {
    private ISignService signService;

    @PostMapping("/changePassword")
    public void changePassword(String password, String email) {
        signService.changePassword(password, email);
    }

    @PostMapping("/changeEmail")
    public void changeEmail(String email) {
        signService.changeEmail(email);
    }

    @PostMapping("/changeName")
    public void changeName(String name, String email) {
        signService.changeName(name, email);
    }
}
