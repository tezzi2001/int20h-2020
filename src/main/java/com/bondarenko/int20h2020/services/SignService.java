package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@PropertySource("classpath:application.properties")
public class SignService implements ISignService {
    private UserRepository userRepository;
    private IJwtService jwtService;
    @Value("${security.local-parameter}")
    private String localParameter;

    @Override
    public JWT register(Person user, String fingerprint) {
        if (userRepository.existsById(user.getEmail())) {
            return null;
        } else {
            String hashedPassword = BCrypt.hashpw(user.getPassword()+localParameter, BCrypt.gensalt());
            user.setPassword(hashedPassword);
            userRepository.save(user);
            return jwtService.getTokensOnAuth(user.getEmail(), user.getPassword(), fingerprint);
        }
    }

    @Override
    public JWT authenticate(String email, String password, String fingerprint) {
        Optional<Person> optionalUser = userRepository.getPersonByEmail(email);
        if (optionalUser.isPresent()) {
            if (optionalUser.get().getPassword().equals(password)) {
                return jwtService.getTokensOnAuth(email, password, fingerprint);
            }
        }
        return null;
    }

    @Override
    public JWT refresh(String refreshToken, String fingerprint) {
        return jwtService.refreshTokens(refreshToken, fingerprint);
    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }
}
