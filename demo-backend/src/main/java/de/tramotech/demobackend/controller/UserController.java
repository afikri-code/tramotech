package de.tramotech.demobackend.controller;

import de.tramotech.demobackend.dto.UserDto;
import de.tramotech.demobackend.mapper.DataMapper;
import de.tramotech.demobackend.model.User;
import de.tramotech.demobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.createUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return new ResponseEntity<User>(userService.getUser(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    ResponseEntity<String> deletePerson(@PathVariable(name="id") Long id) {
        System.out.println("hello");
        userService.removeUser(id);
        return new ResponseEntity("Entity deleted successfully", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = { EmptyResultDataAccessException.class })
    public ResponseEntity<Object> handleEntityNotFoundException(EmptyResultDataAccessException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
