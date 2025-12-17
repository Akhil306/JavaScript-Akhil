package com.example.camelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application Class for Spring Boot + Apache Camel
 * 
 * @SpringBootApplication - This annotation is a combination of:
 * - @Configuration: Marks this class as a source of bean definitions
 * - @EnableAutoConfiguration: Tells Spring Boot to auto-configure based on dependencies
 * - @ComponentScan: Tells Spring to scan this package for components
 */
@SpringBootApplication
public class CamelApplication {

    /**
     * Main method - Entry point of the application
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(CamelApplication.class, args);
        
        System.out.println("\n===========================================");
        System.out.println("🚀 Application Started Successfully!");
        System.out.println("📍 Access the application at: http://localhost:8080");
        System.out.println("📍 Try these endpoints:");
        System.out.println("   - http://localhost:8080/");
        System.out.println("   - http://localhost:8080/api/hello");
        System.out.println("   - http://localhost:8080/api/process?message=YourMessage");
        System.out.println("===========================================\n");
    }
}
