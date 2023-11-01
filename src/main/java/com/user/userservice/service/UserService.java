package com.user.userservice.service;

import com.user.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // user operation

    // Create User
     User saveUser(User user);

    // get all user
    List<User> getAllUser();

    // get single user of given userId
    Optional<User> getUserById(long userId);

    // add for update user
    User updateUser(long userId, User updatedUser);

    // delete user by id
    void deleteUser(long userId);

}
