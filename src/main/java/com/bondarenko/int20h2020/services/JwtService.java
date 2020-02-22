package com.bondarenko.int20h2020.services;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bondarenko.int20h2020.domain.JWT;
import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.domain.entities.Session;
import com.bondarenko.int20h2020.repositories.SessionRepository;
import com.bondarenko.int20h2020.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class JwtService implements IJwtService{
    private SessionRepository sessionRepository;
    private UserRepository userRepository;
    private final Algorithm algorithm = Algorithm.HMAC256(KeyGenerators.secureRandom(50).generateKey());
    private final String issuer = "heroku:spring-boot-rest-api-app";

    private final long ACCESS_TOKEN_DURATION = 24*60*60*1000; // 1 day
    private final long REFRESH_TOKEN_DURATION = 30*24*60*60*1000; // Token expires in 30 days

    @Override
    public JWT refreshTokens(String oldRefreshToken, String fingerprint) {
        Optional<Session> optSession = sessionRepository.getSessionByRefreshToken(oldRefreshToken);
        Session session;
        if (optSession.isPresent()) {
            session = optSession.get();
            sessionRepository.deleteSessionByFingerprint(fingerprint);
        } else {
            return null;
        }

        if (session.getExpiresAt().before(new Date())) {
            return null;
        }

        if (!fingerprint.equals(session.getFingerprint())) {
            return null;
        }

        Person user = userRepository.getPersonByEmail(session.getPerson().getEmail()).get();
        if (user == null) {
            return null;
        }

        String refreshToken = generateRefreshToken();
        session.setUpdatedAt(new Date());
        session.setExpiresAt(new Date(System.currentTimeMillis()+REFRESH_TOKEN_DURATION));
        session.setRefreshToken(refreshToken);
        sessionRepository.save(session);

        return new JWT(refreshToken, generateAccessToken(user));
    }

    @Override
    public JWT getTokensOnAuth(String email, String password, String fingerprint) {
        Person user;
        if (sessionRepository.existsSessionByFingerprint(fingerprint)) sessionRepository.deleteSessionByFingerprint(fingerprint);
        System.out.println("debug: 3");
        if (userRepository.getPersonByEmail(email).isPresent()) {
            user = userRepository.getPersonByEmail(email).get();
            System.out.println("debug: 4");
        } else {
            System.out.println("debug: 5");
            return null;
        }

        String refreshToken = generateRefreshToken();
        sessionRepository.save(new Session(fingerprint, user, refreshToken, new Date(System.currentTimeMillis()+REFRESH_TOKEN_DURATION), new Date(), new Date()));
        System.out.println("debug: 6");
        return new JWT(refreshToken, generateAccessToken(user));
    }

    @Override
    public Person getPersonFromToken(String accessToken) throws IOException {
        JWTVerifier verifier = com.auth0.jwt.JWT.require(algorithm)
                .withIssuer(issuer)
                .build();
        DecodedJWT jwt = verifier.verify(accessToken);
        ObjectMapper mapper = new ObjectMapper();
        return userRepository.getPersonByEmail(mapper.readValue(Base64.getDecoder().decode(jwt.getPayload()), Person.class).getEmail()).orElse(null);
    }

    private String generateRefreshToken() {
        return com.auth0.jwt.JWT
                .create()
                .withIssuer(issuer)
                .withClaim("iat", new Date())
                .withClaim("exp", new Date(System.currentTimeMillis()+REFRESH_TOKEN_DURATION))
                .sign(algorithm);
    }

    private String generateAccessToken(Person user) {
        return com.auth0.jwt.JWT
                .create()
                .withClaim("email", user.getEmail())
                .withClaim("name", user.getName())
                .withClaim("region", user.getRegion())
                .withClaim("sex", user.getSex())
                .withClaim("age", user.getBirthDate())
                .withClaim("groupNumber", user.getBloodGroup().getGroupNumber())
                .withClaim("rh", String.valueOf(user.getBloodGroup().getRh()))
                .withIssuer(issuer)
                .withClaim("iat", new Date())
                .withClaim("exp", new Date(System.currentTimeMillis()+ACCESS_TOKEN_DURATION))
                .sign(algorithm);
    }
}
