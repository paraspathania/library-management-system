# Maven-Based Library Management System

This is a simple Library Management System built with Java and Maven. It demonstrates the use of Maven build lifecycle, plugins, and dependencies.

## Features
- **Book Management**: Add, Remove, Search, and View books.
- **User Management**: Register users and View users.
- **Borrowing System**: Borrow and Return books with status tracking.
- **Console Interface**: Interactive command-line interface.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven

## Project Structure
```
src
├── main
│   └── java
│       └── com
│           └── library
│               ├── Book.java
│               ├── Executer.java
│               ├── Library.java
│               └── User.java
└── test
    └── java
        └── com
            └── library
                └── LibraryTest.java
```

## How to Build
To build the project and generate the JAR file, run:
```bash
mvn clean install
```
This command will:
1. Clean previous builds.
2. Compile the source code.
3. Run the unit tests.
4. Package the application into a JAR file.

## How to Run
After building successfully, you can run the application using:
```bash
java -jar target/library-management-system-1.0-SNAPSHOT.jar
```

## Running Tests
To run the automated JUnit tests:
```bash
mvn test
```

## Author
[Paras Pathania](https://github.com/paraspathania)
