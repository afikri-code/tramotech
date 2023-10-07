package de.tramotech;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class App 
{
    //private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] argv) throws InterruptedException {
int n = 100000;
        for(int i = 0; i < n; i++) {
            log.info("logback message");
           // Thread.sleep(1000);
        }
        Thread.sleep(8000);
        for(int i = 0; i < n; i++) {
            log.info("logback message");
            // Thread.sleep(1000);
        }

    }
}
