package de.tramotech;


public class MyService {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return dividend / divisor;
    }
}

