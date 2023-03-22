package de.tramotech.demo.opencsv;

import de.tramotech.demo.opencsv.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CsvReaderTest {

    @Test
    void validateValide() throws Exception {
        UserDto user = new UserDto(1,"Max Mustermann", "max@email.com", "41514667-d279-11e7-a5ac-f941ac8dfc38");

        Set<ConstraintViolation<UserDto>> violations = DtoValidator.validate(user);

        assertThat(violations).hasSize(0);
    }

    @Test
    void validateWithInvalidUUIDe() throws Exception {
        UserDto user = new UserDto(1,"Max Mustermann", "max@email.com", "415167-d279-11e7-a5ac-f941ac8dfc38");

        Set<ConstraintViolation<UserDto>> violations = DtoValidator.validate(user);

        assertThat(violations).hasSize(1).allSatisfy(e -> e.getMessage().contains("not a valid uuid: 415167-d279-11e7-a5ac-f941ac8dfc38"));
    }



}