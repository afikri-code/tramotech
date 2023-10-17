package de.tramotech.repository;

import de.tramotech.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
}
