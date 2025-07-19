# 🏥 Medical Store Backend API

This is a Spring Boot-based backend application designed to manage the operations of a medical store. It provides RESTful APIs to handle medicine inventory, customer orders, and (planned) user management. Built with scalability and clarity in mind, this project is an ideal foundation for full-stack healthcare or pharmacy applications.

---

## ✨ Features

- ✅ Planned: User Registration and Authentication
- 📦 CRUD operations for managing medicine inventory
- 🛒 Order placement and retrieval
- 🗂 Role handling (User/Admin – planned)
- 🔍 DTOs used for request/response abstraction
- 🧪 Global exception handling using `@ControllerAdvice`
- 🗃️ Integration with MySQL database
- 🔧 Configurable using `application.properties`

---

## 🛠️ Tech Stack

- Java 11+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

## 📁 Project Structure

```
medicalstore-backend/
├── src/
│   ├── main/java/com/medicalstore/
│   │   ├── controller/        # Exposes REST API endpoints
│   │   ├── dto/               # DTOs for API communication
│   │   ├── exception/         # Custom exceptions and global handler
│   │   ├── model/             # JPA entity models
│   │   ├── repository/        # Database access layer
│   │   └── service/           # Business logic implementation
│   └── resources/
│       ├── application.properties  # Configuration
│       └── schema.sql / data.sql (if used)
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites
- Java 11 or newer
- MySQL database server
- Maven build tool

### Clone the Repository
```bash
git clone https://github.com/ASHASALANTRY/medicalstore-backend.git
cd medicalstore-backend
```

### Configure MySQL
Edit `src/main/resources/application.properties` with your local MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/medicalstore
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Run the Application
```bash
mvn spring-boot:run
```

Visit: `http://localhost:8080`

---

## 📘 Sample REST Endpoints

### ✅ List All Medicines
```http
GET /api/medicines
```

### ➕ Add New Medicine
```http
POST /api/medicines
Content-Type: application/json

{
  "name": "Paracetamol",
  "price": 20.0,
  "quantity": 100
}
```

### 📝 Update Existing Medicine
```http
PUT /api/medicines/{id}
Content-Type: application/json

{
  "name": "Paracetamol 650",
  "price": 25.0,
  "quantity": 150
}
```

### ❌ Delete Medicine
```http
DELETE /api/medicines/{id}
```

### 🛒 Place a New Order
```http
POST /api/orders
Content-Type: application/json

{
  "customerId": 1,
  "medicineId": 2,
  "quantity": 3
}
```

---

## 🔧 Exception Handling

This backend includes centralized exception handling with meaningful error responses using:
- `@ControllerAdvice` for global exception mapping
- Custom exception classes like `ResourceNotFoundException`
- Structured error responses returned for invalid inputs or system errors

Example:
```json
{
  "timestamp": "2025-07-19T10:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Medicine with ID 5 not found",
  "path": "/api/medicines/5"
}
```

---

## 🚧 Planned Enhancements

- 🔐 JWT-based authentication and authorization layer
- ✅ User registration and login functionality
- 🧾 Swagger/OpenAPI documentation
- 🗃️ Enhanced search and filtering for medicines

---

## 📌 Notes

- Ensure your MySQL server is up and schema `medicalstore` is created (or set `ddl-auto=create` to auto-generate)
- JWT and user modules are not yet implemented (as of now)
- DTO structure ensures abstraction from entity layer and avoids direct model exposure

---

