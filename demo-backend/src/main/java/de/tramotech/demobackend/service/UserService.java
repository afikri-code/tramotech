package de.tramotech.demobackend.service;

import de.tramotech.demobackend.model.User;
import de.tramotech.demobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }
}
