package de.afikri.rest.quickdemo.controller;

import de.afikri.rest.quickdemo.dto.UserDto;
import de.afikri.rest.quickdemo.mapper.DataMapper;
import de.afikri.rest.quickdemo.model.User;
import de.afikri.rest.quickdemo.service.UserService;
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
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){

        // convert UserDto to User entity
        User user = new User();
        DataMapper.instance.transferData(userDto, user);
        User savedUser = userService.createUser(user);

        // convert User entity to UserDto class
        UserDto userResponse = new UserDto();
        DataMapper.instance.transferData(savedUser, userResponse);


        return new ResponseEntity<UserDto>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return new ResponseEntity<User>(userService.getUser(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deletePerson(@PathVariable(name="id") Long id) {
        userService.removeUser(id);
        return new ResponseEntity("Entity deleted successfully", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = { EmptyResultDataAccessException.class })
    public ResponseEntity<Object> handleEntityNotFoundException(EmptyResultDataAccessException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
