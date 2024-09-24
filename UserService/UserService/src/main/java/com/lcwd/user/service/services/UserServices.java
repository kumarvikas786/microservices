package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserServices {

    //create

    User saveUser(User user);

    //getAllUsers

    List<User> getAllUsers();

    //get single user of given Id

    User getUser(String userId);

    //TODO:update, delete

}
