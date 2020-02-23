package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionService implements  ISubscriptionsService{
    private UserRepository userRepository;

    @Override
    public List<String> getFollowers(String email) {
        return userRepository.getPersonByEmail(email).get().getSubscriptions();
    }

    @Override
    public void follow(String followerEmail, String email) {
        Person user = userRepository.getPersonByEmail(followerEmail).get();
        user.addSub(email);
        userRepository.save(user);
    }

    @Override
    public void unFollow(String followerEmail, String email) {
        Person user = userRepository.getPersonByEmail(followerEmail).get();
        user.removeSub(email);
        userRepository.save(user);
    }
}
