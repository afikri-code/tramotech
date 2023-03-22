package de.tramotech.demo.opencsv.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserDto {
    @CsvBindByName(column =  "id")
    int id;
    @CsvBindByName(column = "name")
    @Size(min = 3, max = 50, message = "name size should be between 3 and 50")
    String name;
}
