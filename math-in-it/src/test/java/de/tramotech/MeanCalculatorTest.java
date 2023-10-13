package de.tramotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Ahmed Fikri
 */
class MeanCalculatorTest {

    MeanCalculator calculator = null;

    @BeforeEach
    void setUp() {
        calculator = new MeanCalculator();
    }

    @ParameterizedTest
    @CsvSource({ "1,2,3,4,5,3", "1,10,100,1000,10000,2222.2" })
    void calculateArithmeticMean(double v1, double v2, double v3, double v4, double v5, double expectedMean) {
        double[] values = {v1, v2, v3, v4, v5};
        double calculatedMean = calculator.calculateArithmeticMean(values);
        assertEquals(expectedMean, calculatedMean, 0.001);
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, 2.60517", "1, 10, 100, 1000, 10000, 100.0" })
    public void calculateGeometricMean(double v1, double v2, double v3, double v4, double v5, double expectedMean) {
        double[] values = {v1, v2, v3, v4, v5};
        double calculatedMean = calculator.calculateGeometricMean(values);
        assertEquals(expectedMean, calculatedMean, 0.001);
    }
}