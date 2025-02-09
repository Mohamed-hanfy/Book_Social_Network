# Book Social Network

## Overview
Book Social Network is a web application built using **Spring Boot** that allows users to connect, share, and discuss their favorite books. Users can create profiles, follow other users, post book reviews, and interact with a community of book enthusiasts.

## Features
- **User Management**
  - User registration with email validation
  - Secure account activation via email
  - JWT-based authentication
  
- **Book Management**
  - Create and update book listings
  - Upload book cover images
  - Share books with community
  - Archive management
  
- **Borrowing System**
  - Book borrowing requests
  - Approval workflow
  - Return management
  - Transaction history
  
- **Social Features**
  - Book reviews and ratings
  - User feedback system
  - Community interaction

## Project Architecture

```
book-network/
├── src/
│   ├── main/
│   │   ├── java/com/mohamed/book_network/
│   │   │   ├── auth/               # Authentication logic
│   │   │   ├── book/               # Book entity and operations
│   │   │   ├── common/             # Shared utilities
│   │   │   ├── config/             # Application configs
│   │   │   ├── email/              # Email services
│   │   │   ├── exception/          # Error handling
│   │   │   ├── feedback/           # Review system
│   │   │   ├── file/              # File management
│   │   │   ├── handler/           # Global handlers
│   │   │   ├── history/           # Transaction records
│   │   │   ├── role/              # Authorization
│   │   │   ├── security/          # Security configs
│   │   │   ├── user/              # User management
│   │   │   └── BookNetworkApiApplication.java
│   │   └── resources/
│   │       ├── application-dev.yml
│   │       ├── application.yml
│   │       ├── static/
│   │       └── templates/
│   └── test/
└── pom.xml
```
## Project Structure Explanation

- **auth/**: Manages authentication and user registration.
- **book/**: Handles book-related functionalities like adding, updating, and retrieving books.
- **common/**: Contains common utility classes and base entities.
- **config/**: Stores application configuration settings.
- **email/**: Manages email notifications and templates.
- **exception/**: Defines custom exceptions for error handling.
- **feedback/**: Handles book feedback and reviews.
- **file/**: Provides file upload and storage functionality.
- **handler/**: Contains global exception handling mechanisms.
- **history/**: Maintains a record of book borrowing transactions.
- **role/**: Manages user roles and permissions.
- **security/**: Configures security settings including JWT authentication.
- **user/**: Manages user data and authentication tokens.
  
## Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL
- Docker

### Installation

1. Clone the repository:
```bash
git clone https://github.com/Mohamed-hanfy/Book_Social_Network.git
cd Book_Social_Network
```

2. Configure database settings in `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/book_social_network
    username: your_username
    password: your_password
```

3. Start the database:
```bash
docker-compose up -d
```

4. Build and run:
```bash
mvn clean install
mvn spring-boot:run
```

Access the application at `http://localhost:8080/api/v1`

## API Documentation

### Base URL
```
http://localhost:8080/api/v1
```

### Authentication Endpoints
- **POST** `/auth/register` - Register new user
- **GET** `/auth/activate-account?token=<string>` - Activate account
- **POST** `/auth/authenticate` - Login

### Book Endpoints

#### Core Operations
- **POST** `/books/save` - Create/update book
- **GET** `/books` - List all books
- **GET** `/books/{id}` - Get book details
- **POST** `/books/cover` - Upload cover image
- **PATCH** `/books/shareable/{bookId}` - Update sharing status
- **PATCH** `/books/archived/{bookId}` - Update archive status

#### Borrowing System
- **POST** `/books/borrow` - Request to borrow
- **PATCH** `/books/borrow/{bookId}` - Process borrow request
- **PATCH** `/books/borrow/approve/{bookId}` - Approve borrow
- **PATCH** `/books/return/{bookId}` - Return book
- **PATCH** `/books/return/approve/{bookId}` - Approve return

#### Book Lists
- **GET** `/books/borrowed` - View borrowed books
- **GET** `/books/returned` - View returned books
- **GET** `/books/owner` - View books by owner

### Feedback Endpoints
- **POST** `/feedbacks` - Submit feedback
- **GET** `/feedbacks/book/{bookId}` - View book feedback

### Swagger Documentation
Access the full API documentation at:
```
http://localhost:8080/api/v1/swagger-ui.html
```
### ERD Diagram
![image](https://github.com/user-attachments/assets/092caa2b-e87f-40ca-a9cd-7b2c13d3fa53)

## Development

### Workflow
1. Create feature branch
2. Implement changes
3. Test thoroughly
4. Submit pull request
5. Await review



## License
This project is licensed under the MIT License.

## Support
For support or inquiries, contact [Mohamed Hanafy](mailto:mohamed.hanafy.mostafa@gmail.com)

---
