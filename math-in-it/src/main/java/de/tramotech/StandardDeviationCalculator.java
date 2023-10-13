package de.tramotech;

public class StandardDeviationCalculator {
    public double calculateStandardDeviation(double[] data) {
        int n = data.length;

        if (n < 2) {
            // Standard deviation is undefined for a sample with less than 2 data points.
            throw new IllegalArgumentException("Sample size must be at least 2.");
        }

        // Step 1: Calculate the mean (average) of the data.
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        double mean = sum / n;

        // Step 2: Calculate the sum of squared differences from the mean.
        double sumOfSquaredDifferences = 0;
        for (double value : data) {
            double difference = value - mean;
            sumOfSquaredDifferences += difference * difference;
        }

        // Step 3: Calculate the variance (average of squared differences).
        double variance = sumOfSquaredDifferences / (n - 1);

        // Step 4: Calculate the standard deviation (square root of the variance).
        double standardDeviation = Math.sqrt(variance);

        return standardDeviation;
    }
}

