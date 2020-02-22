package com.bondarenko.int20h2020.repositories;

import com.bondarenko.int20h2020.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, String> {
    public Optional<Person> getPersonByEmail(String email);

}
