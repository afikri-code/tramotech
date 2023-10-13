package de.tramotech;

import java.util.Arrays;

public class SimpleLinearRegression {
    public static void main(String[] args) {
        // Sample dataset (replace with your own data)
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 3, 4, 4, 5};

        // Calculate the slope (m) and intercept (b) for the linear regression model
        double[] regressionCoefficients = calculateSimpleLinearRegression(x, y);
        double m = regressionCoefficients[0];
        double b = regressionCoefficients[1];

        // Display the equation of the regression line
        System.out.println("Regression Line Equation: y = " + m + "x + " + b);
    }

    public static double[] calculateSimpleLinearRegression(double[] x, double[] y) {
        int n = x.length;

        // Calculate the means of x and y
        double xMean = Arrays.stream(x).average().orElse(0);
        double yMean = Arrays.stream(y).average().orElse(0);

        // Calculate the slope (m) and intercept (b) for the regression model
        double numerator = 0;
        double denominator = 0;

        for (int i = 0; i < n; i++) {
            numerator += (x[i] - xMean) * (y[i] - yMean);
            denominator += (x[i] - xMean) * (x[i] - xMean);
        }

        double m = numerator / denominator;
        double b = yMean - m * xMean;

        return new double[] { m, b };
    }
}
