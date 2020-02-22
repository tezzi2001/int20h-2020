package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> getUserByEmail(String email);

}
