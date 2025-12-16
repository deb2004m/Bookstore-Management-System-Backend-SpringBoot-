# 📚 Bookstore Order Management API

A **Spring Boot + MongoDB** based backend project for an online bookstore. The application supports **JWT-based authentication**, **role-based authorization (Admin / Customer)**, and a complete **Order Management system**.

This project is suitable for:

* Final year / academic projects
* Resume & portfolio
* Interview demonstrations

---

## 🚀 Features

### 🔐 Authentication & Authorization

* User Registration & Login
* JWT-based authentication
* Role-based access control

  * **ADMIN**
  * **CUSTOMER**

### 📚 Book Management

* Add, update, delete books (Admin)
* View books (Customer)

### 🛒 Order Management

* Place orders (Customer)
* View all orders (Admin)
* View order by ID
* Update order status (Admin)
* Embedded order items (MongoDB optimized)

### 🗄 Database

* MongoDB (NoSQL)
* Embedded documents for order items

---

## 🛠 Tech Stack

| Technology      | Description                    |
| --------------- | ------------------------------ |
| Java            | Backend language               |
| Spring Boot     | Application framework          |
| Spring Security | Authentication & Authorization |
| JWT             | Token-based security           |
| MongoDB         | NoSQL Database                 |
| Lombok          | Boilerplate code reduction     |
| Maven           | Dependency management          |
| Postman         | API testing                    |

---

## 📂 Project Structure

```
com.BookStore.bookstore_management
│
├── api
│   ├── controller
│   │   ├── AuthController.java
│   │   ├── OrderController.java
│   │
│   ├── service
│   │   ├── OrderService.java
│   │
│   ├── repository
│   │   ├── UserRepository.java
│   │   ├── OrderRepository.java
│   │   ├── BookstoreRepository.java
│   │
│   ├── model
│   │   ├── User.java
│   │   ├── Order.java
│   │   ├── OrderItem.java
│   │   ├── BookStore.java
│   │
│   ├── security
│   │   ├── JwtUtility.java
│   │   ├── JwtFilter.java
│   │   ├── SecurityConfig.java
│   │   ├── CustomerUserDetailsService.java
│   │
│   └── DTOs
│       ├── LoginRequest.java
│       ├── RegisterRequest.java
│       ├── PlaceOrderRequest.java
│       ├── OrderItemRequest.java
│
└── BookstoreManagementApplication.java
```

---

## 🔐 API Endpoints

### 🔑 Authentication

| Method | Endpoint       | Access |
| ------ | -------------- | ------ |
| POST   | /auth/register | Public |
| POST   | /auth/login    | Public |

---

### 🛒 Orders

| Method | Endpoint                | Access           |
| ------ | ----------------------- | ---------------- |
| POST   | /api/orders             | CUSTOMER         |
| GET    | /api/orders             | ADMIN            |
| GET    | /api/orders/{id}        | ADMIN / CUSTOMER |
| PUT    | /api/orders/{id}/status | ADMIN            |

---

## 📦 Sample JSON Requests

### 🔐 Login

```json
{
  "email": "customer@gmail.com",
  "password": "password123"
}
```

---

### 🛒 Place Order

```json
{
  "items": [
    { "bookId": "101", "quantity": 2 },
    { "bookId": "102", "quantity": 1 }
  ]
}
```

---

## 🧠 Order Data Model (MongoDB)

```json
{
  "_id": "652fa3b9",
  "userId": "12345",
  "customerName": "Debashis Moharana",
  "customerEmail": "deb@gmail.com",
  "items": [
    { "bookId": "101", "bookTitle": "Java Basics", "quantity": 2, "price": 500 }
  ],
  "totalAmount": 1000,
  "status": "PENDING",
  "paymentStatus": "PAID",
  "orderDate": "2025-12-16T11:30:00"
}
```

---

## ▶️ How to Run the Project

### Prerequisites

* Java 17+
* MongoDB (running locally or cloud)
* Maven

### Steps

```bash
# Clone repository
git clone <your-repo-url>

# Navigate to project
cd bookstore_management

# Build project
mvn clean install

# Run application
mvn spring-boot:run
```

---

## 🔧 Configuration (application.properties)

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/bookstore_db
spring.data.mongodb.database=bookstore_db
server.port=8080

jwt.secret=your_secret_key
jwt.expiration=3600000
```

---

## 🧪 Testing

* Use **Postman** for API testing
* Add JWT token in Authorization header:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## 📌 Key Learning Outcomes

* JWT authentication in Spring Boot
* MongoDB document modeling
* Role-based API security
* RESTful API design
* Clean service-repository architecture

---

## 👨‍💻 Author

**Debashis Moharana**
B.Tech (CSE) | Java & Full Stack Developer

---

## ⭐ Future Enhancements

* Payment gateway integration
* Order cancellation
* Pagination & filtering
* Docker support
* Cloud deployment

---

⭐ If you like this project, give it a star on GitHub!
