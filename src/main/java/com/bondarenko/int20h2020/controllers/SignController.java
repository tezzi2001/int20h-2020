package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.BloodGroup;
import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.services.ISignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class SignController {
    private ISignService signService;

    @PostMapping("/checkEmail")
    public Map<String, Boolean> checkEmail(String email) {
        return new HashMap<String, Boolean>() {{
            put("isExist", signService.checkEmail(email));
        }};
    }

    @PostMapping("/login")
    public JWT authenticate(String email, String password, String fingerprint) {
        return signService.authenticate(email, password, fingerprint);
    }

    @PostMapping("/register")
    public JWT register(String email, String password, String birthDate, String name, String region, String sex, int groupNumber, char rh, String fingerprint) {
        return signService.register(new Person(email, password, new Date(Date.parse(birthDate)), name, region, sex, new BloodGroup(groupNumber, rh)), fingerprint);
    }

    @PostMapping("/refresh")
    public JWT refresh(String refreshToken, String fingerprint) {
        return signService.refresh(refreshToken, fingerprint);
    }
}
