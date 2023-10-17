package de.tramotech;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {
    @Test
    public void testDivideByNonZero() {
        MyService myService = new MyService();

        int result = myService.divide(10, 2);

        assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        MyService myService = new MyService();

        assertThrows(IllegalArgumentException.class, () -> {
            myService.divide(10, 0);
        });
    }
}
