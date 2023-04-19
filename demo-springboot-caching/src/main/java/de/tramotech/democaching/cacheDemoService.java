package de.tramotech.democaching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Service class that provides methods for caching and clearing cache.
 * Author: Ahmed Fikri
 */
@Service
public class cacheDemoService {

    /**
     * Method that returns the input parameter after a simulated delay of 5 seconds,
     * and caches the result for subsequent requests with the same input parameter.
     *
     * @param info Input parameter to be processed and returned
     * @return The input parameter after a delay of 5 seconds
     */
    @Cacheable("info")
    public String doSomeWork(String info) {
        try {
            Thread.sleep(5000); // Simulate a delay of 5 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Throw a RuntimeException if interrupted
        }
        return info; // Return the input parameter after the delay
    }

    /**
     * Method that clears the cache named "info".
     *
     * @return A string indicating that the cache has been cleared
     */
    @CacheEvict(cacheNames = "info", allEntries = true)
    public String clearCache() {
        return "cache cleared"; // Return a message indicating that the cache has been cleared
    }
}


