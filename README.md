# JWT-Based Login and Registration System

## About

This project is a Spring Boot application that demonstrates how to implement a secure login and registration system using JSON Web Tokens (JWT) for authentication and authorization. This setup allows users to register, log in, and access secure routes based on their roles (USER or ADMIN), all protected by JWT.

## Setup and Configuration

### 1. Add Dependencies

In your `pom.xml`, add the following dependencies to set up Spring Security, JWT, and database connectivity:

```xml
<dependencies>
    <!-- Spring Boot dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- JWT library -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.11.5</version>
    </dependency>

    <!-- MySQL dependency -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- BCrypt for password encoding -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-crypto</artifactId>
    </dependency>
</dependencies>
```

### 2. Configure `application.properties`

Set up your database and JWT secret key in `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/loginsystem
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

# JWT Secret Key
app.jwt.secret=YourSecretKeyForJWTGeneration
```

Make sure to create the `loginsystem` database in MySQL.

### 3. Create Entity Classes

You will need two main classes for the entity setup:

- **User Entity**: Represents a user with fields such as username, password, email, and roles.
- **Role Enum**: Defines the user roles, such as USER and ADMIN.

### 4. Set Up Security Configuration

Create a `SecurityConfig` class to configure HTTP security, role-based access, and the JWT authentication filter.

### 5. Implement User Authentication and Authorization

- **UserDetailsService**: Custom service to load user details based on the username.
- **JWT Utility Class**: Provides methods to generate, validate, and extract JWT tokens.
- **JWT Authentication Filter**: Intercepts HTTP requests to check for a valid JWT in the Authorization header.

## Endpoints and Key Features

### Endpoints

1. **User Registration**

   - **URL**: `POST /api/auth/register`
   - **Description**: Registers a new user.
   - **Request Body**: JSON with username, password, and email.
   
2. **User Login**

   - **URL**: `POST /api/auth/login`
   - **Description**: Authenticates a user and returns a JWT token.
   - **Request Parameters**: `username` and `password`.
   
3. **User Home (USER Role)**

   - **URL**: `GET /api/user/home`
   - **Description**: Accessed by users with the USER role.
   
4. **Admin Home (ADMIN Role)**

   - **URL**: `GET /api/admin/home`
   - **Description**: Accessed by users with the ADMIN role.

### Important Considerations

- Use **JWT tokens** for secure access to protected routes.
- The **Role-based Authorization** restricts certain routes to specific user roles (USER/ADMIN).
- Ensure the **JWT secret key** is kept secure.

## Example Flow

1. Register a new user by sending a `POST` request to `/api/auth/register`.
2. Log in using the `/api/auth/login` endpoint and receive a JWT token.
3. Use the JWT token in the `Authorization` header to access protected routes like `/api/user/home` or `/api/admin/home`.

## Why Use JWT?

JWT (JSON Web Token) is a widely used mechanism for securing APIs. It allows:
- **Stateless Authentication**: No need to store session data on the server.
- **Cross-Platform Usage**: Tokens can be used across different platforms (e.g., mobile apps, web apps).
- **Compact and URL-safe**: JWT is compact and can be transmitted easily in URL parameters, HTTP headers, or cookies.
- **Scalability**: Since JWT is stateless, it can be used in distributed and microservice architectures.

## Conclusion

This JWT-based login and registration system demonstrates how to use JWT for authentication and authorization in a Spring Boot application. By implementing secure user registration, login, and role-based access control, this project serves as a foundation for understanding the practical use of JWT in web applications.

