package com.bondarenko.int20h2020.security;

import com.bondarenko.int20h2020.domain.entities.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class SecurityUser implements UserDetails {

    private final String email;
    private final String password;
    private final Set<SimpleGrantedAuthority> authorities;
    private final boolean isActive;
    private final boolean isNonLocked;
    private final boolean  isNonExpired;
    private final boolean  isEnabled;

    public SecurityUser(User user) {
        this(user.getEmail(), user.getPassword(), user.getRole().getAuthorities(), true, true, true, true);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
