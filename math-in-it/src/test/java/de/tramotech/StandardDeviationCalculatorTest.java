package de.tramotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StandardDeviationCalculatorTest {

    StandardDeviationCalculator standardDeviationCalculator = null;

    @BeforeEach
    void setUp() {
        standardDeviationCalculator = new StandardDeviationCalculator();
    }

    @ParameterizedTest
    @CsvSource({"2.3, 3.1, 4.0, 4.2, 5.7, 1.2778"})
    void calculateStandardDeviation(double v1, double v2, double v3, double v4, double v5, double expectedValue) {
        double[] data = {v1, v2, v3, v4, v5};

        double result = standardDeviationCalculator.calculateStandardDeviation(data);

        assertEquals(expectedValue, result, 0.001);
    }
}