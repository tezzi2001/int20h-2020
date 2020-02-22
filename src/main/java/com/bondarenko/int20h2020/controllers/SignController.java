package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.services.ISignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
