# Maven-Based Library Management System (Web App)

This is a Library Management System built with **Spring Boot**, **Thymeleaf**, and **Maven**.

## Features
- **Web Interface**: Beautiful dashboard to manage books.
- **Book Management**: Add, Borrow, and Return books via UI.
- **REST API**: Underlying Controller structure.
- **DevOps Ready**: CI/CD with GitHub Actions.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven

## How to Run
1. Build the project:
   ```bash
   mvn clean install
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Open your browser and go to:
   [http://localhost:8080](http://localhost:8080)

## Project Structure
- `src/main/java/com/library/controller`: Web Controllers.
- `src/main/resources/templates`: HTML Views (Thymeleaf).
- `src/main/java/com/library`: Domain models.

## Author
[Paras Pathania](https://github.com/paraspathania)
