package com.bondarenko.int20h2020.security;

import com.bondarenko.int20h2020.domain.entities.User;
import com.bondarenko.int20h2020.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = userRepository
                .findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException(s));
        return new SecurityUser(user);
    }
}
