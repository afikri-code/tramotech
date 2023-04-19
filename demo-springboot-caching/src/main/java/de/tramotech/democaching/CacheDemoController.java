package de.tramotech.democaching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class that handles HTTP requests for caching demo.
 * Author: Ahmed Fikri
 */
@RestController
@RequestMapping("/")
public class CacheDemoController {

    @Autowired
    cacheDemoService service; // Autowired instance of the cacheDemoService class

    /**
     * HTTP GET method that returns the input parameter after processing it
     * through the doSomeWork() method of the cacheDemoService class,
     * which caches the result for subsequent requests with the same input parameter.
     *
     * @param info Input parameter to be processed and returned
     * @return The processed input parameter
     */
    @GetMapping("/{info}")
    public String getInfo(@PathVariable("info") String info) {
        return service.doSomeWork(info);
    }

    /**
     * HTTP GET method that clears the cache for the doSomeWork() method
     * of the cacheDemoService class.
     *
     * @return A string indicating that the cache has been cleared
     */
    @GetMapping("/clearcache")
    public String evictCache() {
        return service.clearCache();
    }
}

