# Spring Boot + Apache Camel Web Application 🚀

> A beginner-friendly web application demonstrating the integration of **Java**, **Spring Boot**, and **Apache Camel**

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Apache Camel](https://img.shields.io/badge/Apache%20Camel-4.0.3-blue.svg)](https://camel.apache.org/)

## 🎯 What is This?

This is a **complete, working web application** that teaches you how to:
- Build RESTful APIs with Spring Boot
- Integrate Apache Camel for message routing
- Create enterprise integration patterns
- Build a modern web interface

Perfect for beginners learning Java web development!

## ✨ Features

- ✅ **RESTful API** - Multiple endpoints for different operations
- ✅ **Apache Camel Routes** - Message processing and transformation
- ✅ **Content-Based Routing** - Smart message routing based on content
- ✅ **Timer Route** - Scheduled tasks with Apache Camel
- ✅ **Web Interface** - Beautiful, interactive UI to test the API
- ✅ **Well-Documented Code** - Every file has detailed comments
- ✅ **Production Ready** - Follows best practices and patterns

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher ([Download](https://adoptium.net/))
- Maven 3.6+ ([Download](https://maven.apache.org/download.cgi))

### Run the Application

```bash
# Clone the repository
git clone https://github.com/Akhil306/JavaScript-Akhil.git
cd JavaScript-Akhil

# Run with Maven
mvn spring-boot:run

# Or build and run the JAR
mvn clean package
java -jar target/springboot-camel-app-1.0.0.jar
```

### Access the Application

Open your browser and visit:
- **Web UI**: http://localhost:8080
- **API**: http://localhost:8080/api/hello

## 📖 Complete Tutorial

For a **detailed step-by-step guide**, see [TUTORIAL.md](TUTORIAL.md)

The tutorial covers:
- Understanding Spring Boot and Apache Camel
- Project structure explanation
- Code walkthrough with detailed comments
- How to test and extend the application

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Interactive web interface |
| GET | `/api/hello` | Simple greeting from Camel route |
| GET | `/api/process?message=text` | Process and transform a message |
| POST | `/api/process` | Process message from request body |
| GET | `/api/route?message=text` | Content-based routing demo |
| GET | `/api/info` | Application information (JSON) |

## 🧪 Try It Out

### Using cURL
```bash
# Simple greeting
curl http://localhost:8080/api/hello

# Process a message
curl "http://localhost:8080/api/process?message=HelloWorld"

# Content-based routing
curl "http://localhost:8080/api/route?message=urgent%20task"

# Get app info (JSON)
curl http://localhost:8080/api/info
```

### Using the Web Interface
1. Open http://localhost:8080 in your browser
2. Use the interactive buttons to test different endpoints
3. See real-time responses!

## 📁 Project Structure

```
├── pom.xml                                 # Maven dependencies
├── src/main/
│   ├── java/com/example/camelapp/
│   │   ├── CamelApplication.java          # Main application class
│   │   ├── CamelRoutes.java               # Camel route definitions
│   │   └── ApiController.java             # REST API endpoints
│   └── resources/
│       ├── application.properties          # Configuration
│       └── static/index.html               # Web UI
└── TUTORIAL.md                             # Detailed tutorial
```

## 🎓 What You'll Learn

### Spring Boot Concepts
- Auto-configuration and component scanning
- Dependency injection with `@Autowired`
- REST controllers with `@RestController`
- Application properties and configuration

### Apache Camel Concepts
- Route definitions with RouteBuilder
- Direct endpoints for in-memory routing
- Message transformation and processing
- Content-based routing
- Timer component for scheduled tasks
- ProducerTemplate for sending messages

### Integration Patterns
- Request-Reply pattern
- Content-Based Router
- Message Transformer
- Timer/Scheduler pattern

## 🛠️ Technologies Used

- **Java 17** - Programming language
- **Spring Boot 3.1.5** - Application framework
- **Apache Camel 4.0.3** - Integration framework
- **Maven** - Build tool
- **Embedded Tomcat** - Web server

## 🔧 Configuration

Edit `src/main/resources/application.properties`:

```properties
# Change server port
server.port=8080

# Configure logging
logging.level.org.apache.camel=INFO

# Application name
spring.application.name=SpringBoot-Camel-App
```

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Apache Camel Documentation](https://camel.apache.org/)
- [Complete Tutorial](TUTORIAL.md) - Detailed guide included in this repo

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Report bugs
- Suggest features
- Submit pull requests

## 📝 License

This project is open source and available for educational purposes.

## 💡 Tips for Beginners

1. **Start with the Tutorial** - Read [TUTORIAL.md](TUTORIAL.md) for detailed explanations
2. **Explore the Code** - Each file has extensive comments
3. **Run the Application** - See it in action at http://localhost:8080
4. **Try the Examples** - Use the web interface to test different endpoints
5. **Modify and Experiment** - Change the code and see what happens!

## 🆘 Troubleshooting

**Port already in use?**
- Change `server.port` in `application.properties`

**Maven errors?**
- Run `mvn clean install -U`

**Java version issues?**
- This requires Java 17+, check with `java -version`

See [TUTORIAL.md](TUTORIAL.md) for more troubleshooting tips.

## 🌟 Features to Try

- **Timer Route**: Watch the console for automatic log messages every 30 seconds
- **Message Processing**: Send messages and see them transformed
- **Content Routing**: Try messages with "urgent" or "info" keywords
- **Web Interface**: Use the beautiful UI to test all endpoints

---

**Made with ❤️ for learning Java, Spring Boot, and Apache Camel**

If you find this helpful, please give it a ⭐!