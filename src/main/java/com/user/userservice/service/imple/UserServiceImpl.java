package com.user.userservice.service.imple;

import com.user.userservice.model.User;
import com.user.userservice.repository.UserRepository;
import com.user.userservice.service.UserService;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId);
    }


    // add for update user
    public User updateUser(long userId, User updatedUser) {
        // Check if the user exists
        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            // Update the user's information
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setAbout(updatedUser.getAbout());

            return userRepository.save(existingUser);
        } else {
            throw new EntityNotFoundException("User with ID " + userId + " not found"); // User not found
        }
    }

    // delete user by id
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }
}
