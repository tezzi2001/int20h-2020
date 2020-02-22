package com.bondarenko.int20h2020.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWT {
    private String refreshToken;
    private String accessToken;
}
