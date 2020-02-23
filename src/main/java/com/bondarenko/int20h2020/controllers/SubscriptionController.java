package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.services.ISubscriptionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class SubscriptionController {
    private ISubscriptionsService subscriptionsService;

    @PostMapping("/getFollowers")
    public List<String> getFollowers(String email) {
        return subscriptionsService.getFollowers(email);
    }

    @PostMapping("/follow")
    public void follow(String followerEmail, String email) {
        subscriptionsService.follow(followerEmail, email);
    }

    @PostMapping("/unFollow")
    public void unFollow(String followerEmail, String email) {
        subscriptionsService.unFollow(followerEmail, email);
    }
}
