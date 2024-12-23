# Student Management System

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/status-Active-green.svg)]()

## Overview

The **Student Management System** is a backend application developed using **Spring Boot** to demonstrate CRUD operations for managing students and their associated classes. This project focuses on implementing RESTful APIs for a many-to-one relationship between `Student` and `Class` entities. It serves as a learning exercise for Spring Boot and SQL database integration.

## Features

- **Add Students and Classes:**
  - Create student records and assign them to a class.
- **Update Records:**
  - Modify student or class details.
- **View Records:**
  - Fetch a list of students or classes.
  - Retrieve details of a specific student or class.
- **Delete Records:**
  - Remove student or class entries.
- **Exception Handling:**
  - Custom exception handling to manage errors gracefully.

## Technology Stack

- **Backend:** Spring Boot (Java)
- **Database:** SQL (e.g., MySQL, PostgreSQL, or H2 for testing)
- **Testing:** Postman for API testing

## Setup and Installation

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (Version 11 or later)
- [Maven](https://maven.apache.org/) (for dependency management)
- An SQL database (e.g., MySQL or PostgreSQL)

### Steps to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Tusharnair0/Student-Management.git
   cd Student-Management
   ```

2. **Configure the Database:**
   - Update the `application.properties` file with your database connection details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/student_management
     spring.datasource.username=YOUR_USERNAME
     spring.datasource.password=YOUR_PASSWORD
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build the Project:**
   ```bash
   mvn clean install
   ```

4. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```

5. **Test the APIs:**
   - Use Postman or any API client to test endpoints such as:
     - `POST /students`
     - `GET /students`
     - `PUT /students/{id}`
     - `DELETE /students/{id}`

## API Endpoints

### Student Endpoints
- **POST /students:** Add a new student.
- **GET /students:** Get a list of all students.
- **GET /students/{id}:** Get details of a specific student.
- **PUT /students/{id}:** Update a student record.
- **DELETE /students/{id}:** Delete a student record.

### Class Endpoints
- **POST /classes:** Add a new class.
- **GET /classes:** Get a list of all classes.
- **GET /classes/{id}:** Get details of a specific class.
- **PUT /classes/{id}:** Update a class record.
- **DELETE /classes/{id}:** Delete a class record.

## Folder Structure

```plaintext
Student-Management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.studentmanagement/
│   │   │   │   ├── controller/
│   │   │   │   ├── entity/
│   │   │   │   ├── exception/
│   │   │   │   ├── repository/
│   │   │   │   ├── service/
│   │   │   │   └── StudentManagementApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
├── pom.xml
├── README.md
└── LICENSE
```

## Testing

- **API Testing:**
  - Use tools like Postman to verify the CRUD operations.
- **Database Verification:**
  - Check the database tables to ensure data consistency.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or suggestions, reach out:

- **Name:** Tushar Surendra Nair
- **GitHub:** [Tusharnair0](https://github.com/Tusharnair0)
- **Email:** [1tusharnair@gmail.com](mailto:1tusharnair@gmail.com)
- **LinkedIn:** [Tushar Nair](https://www.linkedin.com/in/tushar-nair-shrine101/)

---

### Acknowledgments

Special thanks to Spring Boot and SQL community resources that facilitated this learning project.
