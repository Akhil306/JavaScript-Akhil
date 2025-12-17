package com.example.camelapp;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller - Handles HTTP requests
 * 
 * @RestController - Combines @Controller and @ResponseBody
 * @RequestMapping - Maps HTTP requests to handler methods
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    /**
     * ProducerTemplate - Used to send messages to Camel routes
     * @Autowired - Spring automatically injects this dependency
     */
    @Autowired
    private ProducerTemplate producerTemplate;

    /**
     * GET endpoint: /api/hello
     * Simple endpoint that uses a Camel route
     * 
     * Example: http://localhost:8080/api/hello
     */
    @GetMapping("/hello")
    public String hello() {
        // Send a message to the 'direct:greeting' Camel route
        // and return the response
        return producerTemplate.requestBody("direct:greeting", null, String.class);
    }

    /**
     * GET endpoint: /api/process
     * Processes a message using a Camel route
     * 
     * Example: http://localhost:8080/api/process?message=test
     * 
     * @param message The message to process (query parameter)
     */
    @GetMapping("/process")
    public String processMessage(@RequestParam(defaultValue = "Default Message") String message) {
        // Send the message to the 'direct:processMessage' Camel route
        // and return the processed result
        return producerTemplate.requestBody("direct:processMessage", message, String.class);
    }

    /**
     * POST endpoint: /api/process
     * Processes a message sent in the request body
     * 
     * Example: POST http://localhost:8080/api/process
     * Body: "Your message here"
     * 
     * @param message The message to process (request body)
     */
    @PostMapping("/process")
    public String processMessagePost(@RequestBody String message) {
        return producerTemplate.requestBody("direct:processMessage", message, String.class);
    }

    /**
     * GET endpoint: /api/route
     * Demonstrates content-based routing
     * 
     * Example: http://localhost:8080/api/route?message=urgent%20task
     * 
     * @param message The message to route (query parameter)
     */
    @GetMapping("/route")
    public String contentBasedRoute(@RequestParam String message) {
        return producerTemplate.requestBody("direct:contentRouter", message, String.class);
    }

    /**
     * GET endpoint: /api/info
     * Returns information about the application
     * 
     * Example: http://localhost:8080/api/info
     */
    @GetMapping("/info")
    public AppInfo getInfo() {
        return new AppInfo(
            "Spring Boot + Apache Camel Web Application",
            "1.0.0",
            "A beginner-friendly example showing integration of Spring Boot and Apache Camel"
        );
    }

    /**
     * Inner class to represent application information
     */
    public static class AppInfo {
        private String name;
        private String version;
        private String description;

        public AppInfo(String name, String version, String description) {
            this.name = name;
            this.version = version;
            this.description = description;
        }

        // Getters
        public String getName() { return name; }
        public String getVersion() { return version; }
        public String getDescription() { return description; }

        // Setters
        public void setName(String name) { this.name = name; }
        public void setVersion(String version) { this.version = version; }
        public void setDescription(String description) { this.description = description; }
    }
}
