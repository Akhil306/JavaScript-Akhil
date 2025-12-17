package com.example.camelapp;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Apache Camel Route Configuration
 * 
 * This class defines the routing logic for Apache Camel.
 * Routes are like pipelines that process and transform messages.
 * 
 * @Component - Marks this as a Spring component so it's automatically detected
 */
@Component
public class CamelRoutes extends RouteBuilder {

    /**
     * Configure method - Define all Camel routes here
     * 
     * Route structure: from(source).to(destination)
     * You can add processors, transformers, and filters in between
     */
    @Override
    public void configure() throws Exception {
        
        // Route 1: Timer Route
        // This route runs every 30 seconds and logs a message
        from("timer:simpleTimer?period=30000")
            .setBody(constant("Timer triggered at: #{date:now:yyyy-MM-dd HH:mm:ss}"))
            .log("🔔 ${body}");
        
        // Route 2: Direct Route for Message Processing
        // This route is triggered by REST endpoints
        from("direct:processMessage")
            .log("📥 Received message: ${body}")
            .process(exchange -> {
                // Get the message from the exchange
                String originalMessage = exchange.getIn().getBody(String.class);
                
                // Transform the message (convert to uppercase and add prefix)
                String processedMessage = "Processed: " + originalMessage.toUpperCase();
                
                // Set the response
                exchange.getIn().setBody(processedMessage);
            })
            .log("📤 Sending response: ${body}");
        
        // Route 3: Direct Route for Greeting
        // Simple greeting route
        from("direct:greeting")
            .log("👋 Greeting route called")
            .setBody(constant("Hello from Apache Camel! 🐫"))
            .log("✅ Response prepared: ${body}");
        
        // Route 4: Content-Based Router Example
        // This demonstrates conditional routing based on message content
        from("direct:contentRouter")
            .choice()
                .when(simple("${body} contains 'urgent'"))
                    .log("🚨 URGENT message detected!")
                    .setBody(simple("PRIORITY: ${body}"))
                .when(simple("${body} contains 'info'"))
                    .log("ℹ️  INFO message detected")
                    .setBody(simple("INFO: ${body}"))
                .otherwise()
                    .log("📝 Regular message")
                    .setBody(simple("REGULAR: ${body}"))
            .end();
    }
}
