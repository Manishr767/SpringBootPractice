# Spring Boot MVC Practice

A university/practice project for learning server-side web development with Spring Boot, Spring MVC, Thymeleaf, and JDBC. The application demonstrates a basic member workflow through web pages and database access.

## Technology stack

- Java 21
- Spring Boot 3.5.6
- Spring Web / Spring MVC
- Thymeleaf templates
- MySQL Connector/J
- Gradle

## Project structure

```text
src/main/java/ac/it/MVCTest/
├── DTO/          # Member data transfer object
├── controller/  # Web request handling
├── repository/  # JDBC data access
└── service/     # Application logic
src/main/resources/
├── templates/   # Thymeleaf pages and fragments
└── application.properties
```

## Run locally

### Requirements

- JDK 21
- MySQL
- A database configured for the application

The current configuration expects a local MySQL database named `webserver` and uses port **8089**. Set the database username and password in your local configuration; do not commit credentials.

Run with the Gradle wrapper:

```bash
git clone https://github.com/Manishr767/SpringBootPractice.git
cd SpringBootPractice
./gradlew bootRun
```

Open [http://localhost:8089](http://localhost:8089).

## Learning objectives

- Understand the MVC request lifecycle
- Render server-side HTML using Thymeleaf
- Separate controller, service, and repository responsibilities
- Connect a Spring application to MySQL using JDBC

## Important note

This is a learning project, not a production authentication system. Review password handling, logging, validation, and authorization before reusing the code in a real application.

## Author

**Manish Rauniyar** · [GitHub](https://github.com/Manishr767)
