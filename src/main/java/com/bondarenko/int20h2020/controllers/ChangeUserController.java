package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.services.ISignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ChangeUserController {
    private ISignService signService;

    @PostMapping("/changePassword")
    public Person changePassword(String password, String email) {
        return signService.changePassword(password, email);
    }

    @PostMapping("/changeEmail")
    public Person changeEmail(String email) {
        return signService.changeEmail(email);
    }

    @PostMapping("/changeName")
    public Person changeName(String name, String email) {
        return signService.changeName(name, email);
    }
}
