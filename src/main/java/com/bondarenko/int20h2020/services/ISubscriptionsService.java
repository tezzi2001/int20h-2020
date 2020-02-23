package com.bondarenko.int20h2020.services;

import java.util.List;

public interface ISubscriptionsService {
    List<String> getFollowers(String email);
    void follow(String followerEmail, String email);
    void unFollow(String followerEmail, String email);
}
