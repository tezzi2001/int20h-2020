package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.services.ISignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SignController {
    private ISignService signService;
}
