```markdown
# Spring Boot User Management Application

## Overview

A Java Spring Boot application demonstrating RESTful CRUD operations, pagination, AspectJ logging, in-memory H2 database, table joins, external API calls, and unit testing.

---

## Features

- **User CRUD:** Create, read, update, and delete users via REST endpoints.
- **Search & Pagination:** Search users by name or email with pagination.
- **AspectJ Logging:** Logs all HTTP requests and responses.
- **H2 In-Memory Database:** Quick setup, accessible at `/h2-console`.
- **Table Joins:** Fetch users with their orders using JPA.
- **External API Call:** Example using `RestTemplate`.
- **Unit Testing:** JUnit and Mockito for service and controller layers.

---

## Technologies

- Java 17
- Spring Boot 3.2.0
- Maven
- H2 Database
- Spring Data JPA
- AspectJ (AOP)
- RestTemplate
- JUnit & Mockito

---

## Getting Started

### Prerequisites

- JDK 17
- Maven

### Setup

1. Clone the repository:
   ```
git clone https://github.com/Aayushisharma97/spring-boot-exercise/
   ```
2. Navigate to the project directory:
   ```
cd spring-boot-exercise
   ```
3. Run the application:
   ```
mvn spring-boot:run
   ```

### Access

- API: `http://localhost:8080/api/v1/users`
- H2 Console: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: *(leave empty)*

---

## API Endpoints

- `POST /api/v1/users` — Create user
- `GET /api/v1/users/{id}` — Get user by ID
- `PUT /api/v1/users/{id}` — Update user
- `DELETE /api/v1/users/{id}` — Delete user
- `GET /api/v1/users/search?keyword={searchTerm}&page={pageNumber}&size={pageSize}` — Search users

---

## Testing

- Import the provided Postman collection to test endpoints.
- Run unit tests:
  ```
mvn test
  ```

---

## Project Structure

- `controller/` — REST controllers
- `service/` — Business logic
- `repository/` — JPA repositories
- `dto/` — Data Transfer Objects
- `entity/` — JPA entities
- `aspect/` — AspectJ logging
- `test/` — Unit tests

---

## Author

- Aayushi Sharma
- Contact: aayushi.as97@gmail.com
- GitHub: https://github.com/Aayushisharma97/spring-boot-exercise/

---

Thank you for using this project!
```
