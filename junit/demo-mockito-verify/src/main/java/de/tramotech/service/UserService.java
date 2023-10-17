package de.tramotech.service;

import de.tramotech.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int getUserCount() {
        return userRepository.getAllUsers().size();
    }
}
