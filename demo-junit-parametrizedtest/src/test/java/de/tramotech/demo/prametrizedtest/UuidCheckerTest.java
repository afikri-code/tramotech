package de.tramotech.demo.prametrizedtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UuidCheckerTest {

    private static final String VALID_UUID_1 = "5fd2fb45-2e2f-4bca-a24e-35341981d904";
    private static final String VALID_UUID_2 = "4c12529c-e169-4434-ac93-7f80cd744500";
    private static final String NOT_VALID_UUID_1 = "5fd2fb45-4bca-a24e-35341981d904";
    private static final String NOT_VALID_UUID_2 = "4c12529c-e169-4434-7f80cd744500";


    @ParameterizedTest
    @CsvSource({"5fd2fb45-2e2f-4bca-a24e-35341981d904,true",
            "4c12529c-e169-4434-ac93-7f80cd744500,true",
            "5fd2fb45-4bca-a24e-35341981d906,false",
            "'',false",
            ",false"})
    void checkAllPaths(String uuid, boolean expected) {
        boolean actual = UuidChecker.isValid(uuid);

        assertThat(actual).isEqualTo(expected);
    }



}