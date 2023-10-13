package de.tramotech;

/**
 * Author Ahmed Fikri
 */
public class MeanCalculator {

    // Method to calculate the arithmetic mean of an array of values
    public double calculateArithmeticMean(double[] values) {
        // Initialize a variable to store the sum of values
        double sum = 0;

        // Loop through each value in the array
        for (double value : values) {
            // Add the value to the sum
            sum += value;
        }

        // Calculate and return the arithmetic mean by dividing the sum by the number of values
        return sum / values.length;
    }

    // Method to calculate the geometric mean of an array of values
    public double calculateGeometricMean(double[] values) {
        // Initialize a variable to store the product of values
        double product = 1.0;

        // Loop through each value in the array
        for (double value : values) {
            // Multiply the value with the product
            product *= value;
        }

        // Calculate and return the geometric mean using the formula: nth root of the product
        // where n is the number of values in the array
        return Math.pow(product, 1.0 / values.length);
    }
}

