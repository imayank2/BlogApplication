# Blog Application (Spring Boot Backend)

A RESTful blog management system with JWT authentication, Redis caching, and AWS deployment capabilities.

## Features

- 🚀 **Blog Management**:
  - Create, read, update, and delete blog posts
  - Paginated blog listings
  - JPA/Hibernate with PostgreSQL/MySQL

- 🔒 **Security**:
  - JWT-based authentication
  - Role-based authorization
  - Password encryption

- 🤖 **AI Integration**:
  - OpenAI-powered text summarization
  - Customizable summary length

- ☁️ **Cloud Ready**:
  - Docker containerization
  - AWS deployment (EC2/Elastic Beanstalk)
  - S3 storage for blog images (optional)

- ⚡ **Performance**:
  - Redis caching
  - Pagination
  - Optimized database queries

## Technologies

- **Backend**: Spring Boot 3.1, Java 21
- **Database**: PostgreSQL/MySQL
- **Security**: Spring Security, JWT
- **AI**: OpenAI API
- **Caching**: Redis
- **Cloud**: AWS (EC2, S3, Lambda)
- **Containerization**: Docker

## Prerequisites

- Java 21 JDK
- Maven 3.8+
- PostgreSQL/MySQL
- Redis (optional)
- Docker (optional)
- AWS CLI (for deployment)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/blog-application.git
   cd blog-application
   ```
2. **Configure database**:
   Create a database in PostgreSQL/MySQL
  Update application.properties:
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/blogdb
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   ```
3. **Configure JWT**:
   ```bash
   jwt.secret.key=your-256-bit-secret
   jwt.expiration.ms=86400000 # 24 hour
   ```
4. **Build and run**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
