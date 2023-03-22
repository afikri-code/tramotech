package de.tramotech.demo.opencsv.dto;

import de.tramotech.demo.opencsv.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserDto {
    int id;
    @Size(min = 3, max = 50, message = "name size should be between 3 and 50")
    String name;
    @Email(message = "Email is not valid")
    String email;
    @UUID
    String uuid;

}
