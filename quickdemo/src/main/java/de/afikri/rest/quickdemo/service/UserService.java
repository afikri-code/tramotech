package de.afikri.rest.quickdemo.service;

import de.afikri.rest.quickdemo.model.User;
import de.afikri.rest.quickdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        public User createUser(User user) {
            return userRepository.save(user);
        }
    }

