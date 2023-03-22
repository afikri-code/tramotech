package de.tramotech.demo.opencsv;

import de.tramotech.demo.opencsv.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

class CsvReaderTest {
    CsvReader<UserDto> csvReader;

    @BeforeEach
    void setUp() {
        csvReader = new CsvReader(UserDto.class);
    }
    @Test
    void first() throws Exception {
        String x = this.getClass().getClassLoader()
                .getResource("test-data.csv").getFile();
        List<UserDto> dummy = csvReader.beanBuilder(x);
        Set<ConstraintViolation<UserDto>> violations = DtoValidator.validate(dummy.get(0));
        for( ConstraintViolation<UserDto> v:violations) {
            System.out.println(v.getMessage());

        }

        dummy.forEach(System.out::println);
    }

}