package de.tramotech.demospringbootconfiguration.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
        "myapp.property1=testValue1",
        "myapp.property2=99"
})
class MyAppPropertiesTest {
    @Autowired
    private MyAppProperties myAppProperties;

    @Test
    public void testProperty1() {
        assertEquals("testValue1", myAppProperties.getProperty1());
    }

    @Test
    public void testProperty2() {
        assertEquals(99, myAppProperties.getProperty2());
    }
}