package de.tramotech;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DateAndTimeKatasTest {
    DateAndTimeKatas app;

    @BeforeEach
    void setUp() {
        app = new DateAndTimeKatas();
    }
    @ParameterizedTest
    @MethodSource("appointementDataProvider")
    void isValidAppointmentDate(LocalDateTime appointment, boolean expected) {
        assertThat(app.isValidAppointmentDate(appointment)).isEqualTo(expected);

    }

    static Collection<Object[]> appointementDataProvider() {
        return List.of(new Object[][] {
                { LocalDate.of(2023, 4, 17).atTime(10, 0), true }, // Monday at 2:00 PM
                { LocalDate.of(2023, 4, 22).atTime(11, 0), false }, // Saturday at 10:00 AM
                { LocalDate.of(2023, 4, 16).atTime(12, 30), false }, // Sunday at 3:00 PM
                { LocalDate.of(2023, 4, 17).atTime(8, 59), false }, // Monday at 8:59 AM
                { LocalDate.of(2023, 4, 17).atTime(17, 1), false } // Monday at 5:01 PM
        });
    }






}