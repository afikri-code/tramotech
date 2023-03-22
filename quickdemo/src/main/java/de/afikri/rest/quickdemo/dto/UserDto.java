package de.afikri.rest.quickdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data

public class UserDto {
    private long id;

    // user name should not be null or empty
    // user name should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    // email should be a valid email format
    // email should not be null or empty
    @NotEmpty
    @Email
    private String email;
}
