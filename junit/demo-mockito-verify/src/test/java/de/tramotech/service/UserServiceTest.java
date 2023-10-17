package de.tramotech.service;

import de.tramotech.model.User;
import de.tramotech.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    @Test
    public void testGetUserCount() {
        // Arrange
        List<User> users = Arrays.asList(new User("Alice"), new User("Bob"));
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.getAllUsers()).thenReturn(users);

        UserService userService = new UserService(userRepository);

        // Act
        int userCount = userService.getUserCount();

        // Assert
        verify(userRepository, Mockito.times(1)).getAllUsers();
        // In this example, we expect that the `getAllUsers` method is called exactly once.

        // Additional assertions for the business logic.
        // For instance, you can verify that the `userCount` is as expected:
        assertEquals(2, userCount);
    }
}