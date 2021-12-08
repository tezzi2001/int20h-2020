package com.bondarenko.int20h2020.security;

import lombok.Getter;

@Getter
public enum Permission {

    DEFAULT("default");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
