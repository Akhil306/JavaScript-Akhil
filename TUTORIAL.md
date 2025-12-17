# Spring Boot + Apache Camel Web Application 🚀

A comprehensive beginner-friendly guide to building a web application using **Java**, **Spring Boot**, and **Apache Camel**.

## 📋 Table of Contents
- [What You'll Learn](#what-youll-learn)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Understanding the Components](#understanding-the-components)
- [How to Run](#how-to-run)
- [Testing the Application](#testing-the-application)
- [Step-by-Step Explanation](#step-by-step-explanation)
- [API Endpoints](#api-endpoints)
- [Troubleshooting](#troubleshooting)
- [Next Steps](#next-steps)

## 🎯 What You'll Learn

This project demonstrates:
- ✅ Setting up a Spring Boot application
- ✅ Integrating Apache Camel with Spring Boot
- ✅ Creating REST API endpoints
- ✅ Building Camel routes for message processing
- ✅ Using different Camel components (Timer, Direct, HTTP)
- ✅ Content-based routing with Camel
- ✅ Creating a web interface

## 📚 Prerequisites

Before you begin, make sure you have:

1. **Java Development Kit (JDK) 17 or higher**
   - Download from: https://adoptium.net/
   - Verify installation: `java -version`

2. **Apache Maven**
   - Download from: https://maven.apache.org/download.cgi
   - Verify installation: `mvn -version`

3. **A Text Editor or IDE**
   - Recommended: IntelliJ IDEA, Eclipse, or VS Code

## 📁 Project Structure

```
springboot-camel-app/
├── pom.xml                          # Maven configuration file
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/camelapp/
│       │       ├── CamelApplication.java    # Main application class
│       │       ├── CamelRoutes.java         # Camel route definitions
│       │       └── ApiController.java       # REST API endpoints
│       └── resources/
│           ├── application.properties       # Application configuration
│           ├── banner.txt                   # Startup banner
│           └── static/
│               └── index.html               # Web UI
└── README.md                        # This file
```

## 🔍 Understanding the Components

### 1. **Spring Boot** ☕
Spring Boot is a framework that simplifies Java application development:
- Provides embedded web server (Tomcat)
- Auto-configures components based on dependencies
- Makes it easy to create stand-alone applications

### 2. **Apache Camel** 🐫
Apache Camel is an integration framework:
- Routes messages between different systems
- Transforms data formats
- Provides 300+ components for integration (HTTP, File, Database, etc.)
- Uses Enterprise Integration Patterns (EIP)

### 3. **How They Work Together**
- Spring Boot provides the application container and REST endpoints
- Apache Camel handles message routing and transformation
- Spring Boot manages Camel as a Spring component

## 🚀 How to Run

### Method 1: Using Maven (Recommended)

1. **Navigate to the project directory:**
   ```bash
   cd /path/to/springboot-camel-app
   ```

2. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the application:**
   - Open your browser and go to: http://localhost:8080
   - You'll see a beautiful web interface!

### Method 2: Building a JAR file

1. **Build the project:**
   ```bash
   mvn clean package
   ```

2. **Run the JAR file:**
   ```bash
   java -jar target/springboot-camel-app-1.0.0.jar
   ```

### Stopping the Application
- Press `Ctrl + C` in the terminal

## 🧪 Testing the Application

### 1. **Using the Web Interface**
- Navigate to http://localhost:8080
- Use the interactive buttons to test different endpoints
- See real-time responses

### 2. **Using cURL (Command Line)**

**Test greeting endpoint:**
```bash
curl http://localhost:8080/api/hello
```

**Test message processing:**
```bash
curl "http://localhost:8080/api/process?message=HelloWorld"
```

**Test content-based routing:**
```bash
curl "http://localhost:8080/api/route?message=urgent%20task"
curl "http://localhost:8080/api/route?message=info%20update"
```

**Test POST endpoint:**
```bash
curl -X POST http://localhost:8080/api/process \
  -H "Content-Type: text/plain" \
  -d "Test Message"
```

**Get application info (JSON response):**
```bash
curl http://localhost:8080/api/info
```

### 3. **Using a Browser**
Simply paste these URLs in your browser:
- http://localhost:8080/api/hello
- http://localhost:8080/api/process?message=test
- http://localhost:8080/api/route?message=urgent
- http://localhost:8080/api/info

## 📖 Step-by-Step Explanation

### Step 1: Maven Configuration (pom.xml)

The `pom.xml` file defines:
- **Project information** (groupId, artifactId, version)
- **Dependencies** (libraries the project needs)
- **Build configuration** (how to package the application)

Key dependencies:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-spring-boot-starter</artifactId>
</dependency>
```

### Step 2: Main Application Class (CamelApplication.java)

```java
@SpringBootApplication
public class CamelApplication {
    public static void main(String[] args) {
        SpringApplication.run(CamelApplication.class, args);
    }
}
```

**What happens here:**
1. `@SpringBootApplication` tells Spring Boot this is the main class
2. `SpringApplication.run()` starts the embedded web server
3. Spring Boot auto-configures everything based on dependencies

### Step 3: Camel Routes (CamelRoutes.java)

Routes define how messages flow through the application:

```java
from("direct:processMessage")
    .log("Received: ${body}")
    .process(exchange -> {
        String message = exchange.getIn().getBody(String.class);
        exchange.getIn().setBody("Processed: " + message.toUpperCase());
    })
    .log("Sending: ${body}");
```

**Understanding the route:**
- `from("direct:processMessage")` - Start point (triggered by API calls)
- `.log()` - Prints messages to console
- `.process()` - Custom Java code to transform the message
- Message flows from top to bottom

### Step 4: REST Controller (ApiController.java)

Handles HTTP requests:

```java
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ProducerTemplate producerTemplate;
    
    @GetMapping("/hello")
    public String hello() {
        return producerTemplate.requestBody("direct:greeting", null, String.class);
    }
}
```

**Key concepts:**
- `@RestController` - Marks this as a REST API handler
- `@GetMapping("/hello")` - Maps HTTP GET requests to this method
- `ProducerTemplate` - Sends messages to Camel routes
- Method returns the response to the browser

### Step 5: Configuration (application.properties)

```properties
server.port=8080
spring.application.name=SpringBoot-Camel-App
logging.level.org.apache.camel=INFO
```

**Purpose:**
- Sets the server port
- Configures application name
- Controls logging levels

## 🔗 API Endpoints

| Method | Endpoint | Description | Example |
|--------|----------|-------------|---------|
| GET | `/` | Web UI home page | http://localhost:8080/ |
| GET | `/api/hello` | Simple greeting | http://localhost:8080/api/hello |
| GET | `/api/process?message=text` | Process a message | http://localhost:8080/api/process?message=test |
| POST | `/api/process` | Process message from body | POST with body "message" |
| GET | `/api/route?message=text` | Content-based routing | http://localhost:8080/api/route?message=urgent |
| GET | `/api/info` | Application information | http://localhost:8080/api/info |

## 🔧 Troubleshooting

### Problem: Port 8080 is already in use
**Solution:** Change the port in `application.properties`:
```properties
server.port=8081
```

### Problem: Maven not found
**Solution:** Make sure Maven is installed and added to PATH:
```bash
mvn -version
```

### Problem: Java version error
**Solution:** This project requires Java 17+. Check your version:
```bash
java -version
```

### Problem: Dependencies not downloading
**Solution:** Clear Maven cache and rebuild:
```bash
mvn clean install -U
```

## 🎓 Key Concepts Explained

### What is a REST API?
- **REST** = Representational State Transfer
- A way for applications to communicate over HTTP
- Uses standard HTTP methods: GET, POST, PUT, DELETE

### What is a Camel Route?
- A pipeline that processes messages
- Can transform, filter, route, and enrich messages
- Think of it as a conveyor belt in a factory

### What is Dependency Injection?
- Spring automatically provides objects when needed
- Uses `@Autowired` annotation
- No need to manually create objects

### What is a Component in Spring?
- A class managed by Spring
- Uses annotations like `@Component`, `@RestController`, `@Service`
- Spring creates and manages their lifecycle

## 📝 Code Flow Example

When you call `http://localhost:8080/api/process?message=hello`:

1. **Browser** → Sends HTTP GET request
2. **ApiController** → `processMessage()` method receives the request
3. **Controller** → Sends "hello" to Camel route via `ProducerTemplate`
4. **Camel Route** → Receives message in `from("direct:processMessage")`
5. **Camel Route** → Logs received message
6. **Camel Route** → Processes message (converts to uppercase)
7. **Camel Route** → Logs processed message
8. **Camel Route** → Returns "Processed: HELLO"
9. **Controller** → Returns result to browser
10. **Browser** → Displays "Processed: HELLO"

## 🚀 Next Steps

Now that you have a working application, try:

1. **Add more routes:**
   - File processing route
   - Database integration
   - Email sending

2. **Enhance the REST API:**
   - Add more endpoints
   - Implement PUT and DELETE methods
   - Add request validation

3. **Add a database:**
   - Use Spring Data JPA
   - Create entities and repositories
   - Store processed messages

4. **Add error handling:**
   - Try-catch blocks in routes
   - Custom error handlers
   - Dead letter channels

5. **Add security:**
   - Spring Security
   - JWT authentication
   - Role-based access

6. **Dockerize the application:**
   - Create a Dockerfile
   - Build and run in containers

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Apache Camel Documentation](https://camel.apache.org/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)
- [REST API Tutorial](https://restfulapi.net/)

## 🤝 Contributing

Feel free to fork this project and add your own features!

## 📄 License

This project is open source and available for educational purposes.

---

**Happy Coding! 🎉**

If you found this helpful, please give it a ⭐ on GitHub!
