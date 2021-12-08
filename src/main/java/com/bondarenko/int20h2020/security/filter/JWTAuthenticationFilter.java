package com.bondarenko.int20h2020.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bondarenko.int20h2020.domain.entities.User;
import com.bondarenko.int20h2020.domain.dto.TokenWithUserWrapper;
import com.bondarenko.int20h2020.domain.dto.UserDto;
import com.bondarenko.int20h2020.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.EntityNotFoundException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.bondarenko.int20h2020.constants.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final ObjectMapper mapper;
    private final UserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper mapper, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.mapper = mapper;
        this.userRepository = userRepository;
        setFilterProcessesUrl(SIGN_IN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
        try {
            UserDto userDto = mapper.readValue(req.getInputStream(), UserDto.class);

            User user = userRepository
                    .findByEmail(userDto.getEmail())
                    .orElseThrow(() -> new EntityNotFoundException("User not found on authentication"));
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            userDto.getPassword(),
                            user.getRole().getAuthorities())
            );
        } catch (IOException e) {
            throw new AuthenticationException("", e) {
            };
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        String email = ((UserDetails) auth.getPrincipal()).getUsername();
        String token =
                JWT.create()
                .withSubject(email)
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC512(SECRET.getBytes()));


        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found on authentication"));
        TokenWithUserWrapper tokenWithUserWrapper = TokenWithUserWrapper.builder()
                .token(token)
                .email(user.getEmail())
                .id(user.getId())
                .build();
        res.getWriter().write(mapper.writeValueAsString(tokenWithUserWrapper));
        res.getWriter().flush();
    }
}
