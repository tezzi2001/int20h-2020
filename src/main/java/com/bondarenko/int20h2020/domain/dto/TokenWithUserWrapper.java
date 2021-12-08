package com.bondarenko.int20h2020.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenWithUserWrapper {

    private String token;
    private String email;
    private Long id;
}
