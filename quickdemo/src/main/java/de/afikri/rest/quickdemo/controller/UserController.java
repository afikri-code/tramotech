package de.afikri.rest.quickdemo.controller;

import de.afikri.rest.quickdemo.dto.UserDto;
import de.afikri.rest.quickdemo.model.User;
import de.afikri.rest.quickdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){

        // convert UserDto to User entity
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        User savedUser = userService.createUser(user);

        // convert User entity to UserDto class
        UserDto userResponse = new UserDto();
        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());

        return new ResponseEntity<UserDto>(userResponse, HttpStatus.CREATED);
    }
}
