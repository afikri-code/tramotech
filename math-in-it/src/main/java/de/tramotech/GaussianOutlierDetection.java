package de.tramotech;


public class GaussianOutlierDetection {
    public static void main(String[] args) {
        // Sample dataset (you can replace this with your own data)
        double[] data = {12.5, 14.2, 15.3, 16.0, 17.2, 19.8, 200.0};

        // Calculate the mean and standard deviation
        double mean = calculateMean(data);
        double stdDev = calculateStandardDeviation(data, mean);

        // Define a threshold for outliers (e.g., 2 or 3 times the standard deviation)
        double outlierThreshold = 2.0;

        // Identify and print outliers
        System.out.println("Outliers:");
        for (double value : data) {
            if (Math.abs(value - mean) > outlierThreshold * stdDev) {
                System.out.println(value);
            }
        }
    }

    public static double calculateMean(double[] data) {
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    public static double calculateStandardDeviation(double[] data, double mean) {
        double sumOfSquaredDifferences = 0;
        for (double value : data) {
            double difference = value - mean;
            sumOfSquaredDifferences += difference * difference;
        }
        double variance = sumOfSquaredDifferences / (data.length - 1);
        return Math.sqrt(variance);
    }
}

