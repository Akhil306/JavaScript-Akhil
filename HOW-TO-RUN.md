# How to Build and Run - Quick Reference

## Prerequisites Check

1. **Check Java Version**
   ```bash
   java -version
   ```
   Required: Java 17 or higher

2. **Check Maven Version**
   ```bash
   mvn -version
   ```
   Required: Maven 3.6 or higher

## Step-by-Step Instructions

### Step 1: Navigate to Project Directory
```bash
cd /path/to/JavaScript-Akhil
```

### Step 2: Build the Project (First Time)
```bash
mvn clean install
```
This will:
- Download all dependencies
- Compile the Java code
- Create the JAR file in `target/` directory

### Step 3: Run the Application

**Option A: Run with Maven (Recommended for Development)**
```bash
mvn spring-boot:run
```

**Option B: Run the JAR File**
```bash
java -jar target/springboot-camel-app-1.0.0.jar
```

### Step 4: Verify Application is Running

You should see:
```
🚀 Application Started Successfully!
📍 Access the application at: http://localhost:8080
```

### Step 5: Test the Application

**Option 1: Using Web Browser**
- Open: http://localhost:8080
- Click the test buttons

**Option 2: Using cURL**
```bash
curl http://localhost:8080/api/hello
```

**Option 3: Using Browser Address Bar**
- http://localhost:8080/api/hello
- http://localhost:8080/api/process?message=test
- http://localhost:8080/api/info

### Step 6: Stop the Application
- Press `Ctrl + C` in the terminal

## Common Commands

### Clean and Rebuild
```bash
mvn clean package
```

### Run Tests (when added)
```bash
mvn test
```

### Skip Tests and Build
```bash
mvn clean package -DskipTests
```

### Run in Debug Mode
```bash
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```

## Troubleshooting

### Problem: Maven command not found
**Solution:**
1. Install Maven from https://maven.apache.org/download.cgi
2. Add Maven bin directory to PATH
3. Verify: `mvn -version`

### Problem: Port 8080 already in use
**Solution:**
Edit `src/main/resources/application.properties`:
```properties
server.port=8081
```

### Problem: Java version mismatch
**Solution:**
1. Install Java 17+ from https://adoptium.net/
2. Set JAVA_HOME environment variable
3. Verify: `java -version`

### Problem: Dependencies not downloading
**Solution:**
```bash
mvn clean install -U
```

### Problem: Application starts but endpoints don't work
**Solution:**
1. Check console for errors
2. Verify port in logs
3. Try: http://localhost:8080/api/hello

## Development Tips

### Hot Reload
The project includes Spring Boot DevTools for automatic restart when code changes.

### View Logs
Logs are printed to the console. Look for:
- 🔔 Timer messages every 30 seconds
- 📥 Incoming request logs
- 📤 Outgoing response logs

### Change Port
Edit `application.properties`:
```properties
server.port=9090
```

### Enable Debug Logging
Edit `application.properties`:
```properties
logging.level.com.example.camelapp=DEBUG
logging.level.org.apache.camel=DEBUG
```

## Project Files Overview

- **pom.xml** - Maven configuration (dependencies, build settings)
- **src/main/java/** - Java source code
  - CamelApplication.java - Main application class
  - CamelRoutes.java - Camel route definitions
  - ApiController.java - REST API endpoints
- **src/main/resources/** - Configuration and static files
  - application.properties - Application settings
  - static/index.html - Web interface

## Next Steps

1. ✅ Run the application
2. ✅ Test all endpoints
3. ✅ Read the code comments
4. ✅ Modify routes and see changes
5. ✅ Read TUTORIAL.md for deep dive
6. ✅ Build your own features!

## Quick Test Script

Save this as `test.sh` (Linux/Mac) or `test.bat` (Windows):

```bash
#!/bin/bash
echo "Testing Hello Endpoint..."
curl http://localhost:8080/api/hello
echo -e "\n\nTesting Process Endpoint..."
curl "http://localhost:8080/api/process?message=test"
echo -e "\n\nTesting Info Endpoint..."
curl http://localhost:8080/api/info
echo -e "\n\nAll tests completed!"
```

Make executable and run:
```bash
chmod +x test.sh
./test.sh
```

---

For more detailed information, see README.md and TUTORIAL.md
