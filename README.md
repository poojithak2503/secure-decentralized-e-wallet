# Secure Decentralized E-Wallet Application

## Overview

The Secure Decentralized E-Wallet Application is a Java-based peer-to-peer digital payment platform that enables users to securely transfer money between wallets while enforcing strong authentication and fraud prevention mechanisms. The application uses OAuth2 and JWT-based authentication, Role-Based Access Control (RBAC), Multi-Factor Authentication (MFA), Redis-inspired session caching, and MySQL persistence concepts to provide a secure and scalable payment ecosystem.

The project demonstrates enterprise backend development using Spring Boot, Spring Security, REST APIs, Redis caching, authentication mechanisms, and layered architecture commonly used in digital banking and fintech applications.

---

## Features

- User Registration
- Secure Login
- OAuth2 Authentication
- JWT Token Generation
- Role-Based Access Control (RBAC)
- Multi-Factor Authentication (MFA)
- Peer-to-Peer Money Transfer
- Digital Wallet Balance Management
- Fraud Detection Engine
- API Rate Limiting
- Redis Session Management
- Wallet Lock/Unlock
- Wallet Analytics
- RESTful APIs

---

## Technology Stack

| Technology | Version |
|------------|----------|
| Java | 11 |
| Spring Boot | 2.x |
| Spring Security | Latest |
| OAuth2 | Latest |
| JWT | Latest |
| Redis | Latest |
| MySQL | 8.x |
| Maven | 3.x |

---

## Project Structure

```
secure-decentralized-e-wallet
│
├── controller
│     WalletController.java
│
├── model
│     WalletUser.java
│
├── repository
│     WalletRepository.java
│
├── service
│     WalletService.java
│     AuthenticationService.java
│     RedisSessionService.java
│     JwtTokenService.java
│     FraudDetectionService.java
│
├── config
│     SecurityConfiguration.java
│
└── EWalletApplication.java
```

---

# System Architecture

```
                  User

                    │

                    ▼

            WalletController

                    │

                    ▼

           AuthenticationService

                    │

         OAuth2 Authentication

                    │

                    ▼

             JWT Token Service

                    │

                    ▼

         Redis Session Service

                    │

                    ▼

            Wallet Service

                    │

                    ▼

        Fraud Detection Service

                    │

                    ▼

           Wallet Repository

                    │

                    ▼

                 MySQL
```

---

# Authentication Workflow

```
User Login

     │

     ▼

Username & Password Validation

     │

     ▼

Multi-Factor Authentication

     │

     ▼

JWT Token Generation

     │

     ▼

Redis Session Creation

     │

     ▼

Authenticated User
```

---

# Money Transfer Workflow

```
Sender

   │

   ▼

JWT Validation

   │

   ▼

Permission Verification

   │

   ▼

Fraud Detection

   │

   ▼

Balance Verification

   │

   ▼

Transfer Money

   │

   ▼

Update Wallets

   │

   ▼

Transaction Success
```

---

# Security Features

### OAuth2 Authentication

- Secure login process
- Token-based authentication
- Protected REST APIs

---

### JWT Authentication

- Token generation
- Token validation
- Stateless authentication

---

### Role-Based Access Control

```
ADMIN

• View Reports
• Lock Wallet
• Unlock Wallet
• Delete Wallet
• Transfer Money

CUSTOMER

• Transfer Money
• View Balance
• View Profile
```

---

### Multi-Factor Authentication

Every login requires

- Password Validation
- MFA Verification
- JWT Generation
- Active Session Creation

---

### Fraud Prevention

The fraud engine validates

- Invalid Amount
- Insufficient Balance
- Locked Accounts
- Large Transactions
- Suspicious Login Attempts
- OTP Verification

---

### Redis Cache

Redis is used for

- Active Sessions
- API Rate Limiting
- Session Expiration
- Token Cache
- Reduced Database Access

---

## REST APIs

### Register User

```
POST /api/wallet/register
```

Example Request

```json
{
    "userId":101,
    "fullName":"John Smith",
    "email":"john@gmail.com",
    "mobileNumber":"9876543210",
    "walletId":"WALLET1001",
    "walletBalance":5000,
    "role":"CUSTOMER"
}
```

---

### Login

```
POST /api/wallet/login
```

---

### Transfer Money

```
POST /api/wallet/transfer
```

Parameters

```
senderId

receiverId

amount
```

---

### Get All Users

```
GET /api/wallet/users
```

---

### Get Wallet

```
GET /api/wallet/{userId}
```

---

### Lock Wallet

```
PUT /api/wallet/{userId}/lock
```

---

### Unlock Wallet

```
PUT /api/wallet/{userId}/unlock
```

---

### Wallet Report

```
GET /api/wallet/report
```

---

## Wallet Transfer Example

```
Sender

John

Wallet Balance : $5,000

        │

Transfer : $750

        ▼

Receiver

Alice

Wallet Balance : $2,500

        ▼

Final Balances

John : $4,250

Alice : $3,250
```

---

# Business Components

## WalletController

Handles all REST API requests including registration, login, wallet operations, and money transfers.

---

## WalletService

Manages wallet creation, balance updates, transfers, reporting, and account management.

---

## AuthenticationService

Authenticates users, performs MFA verification, and generates authentication tokens.

---

## JwtTokenService

Generates and validates JWT tokens used to secure API requests.

---

## RedisSessionService

Maintains active user sessions, performs API rate limiting, and clears expired sessions.

---

## FraudDetectionService

Detects suspicious transactions, validates transfers, verifies OTPs, and categorizes transaction risk.

---

## WalletRepository

Stores wallet information and performs CRUD operations.

---

## SecurityConfiguration

Defines public endpoints and role-based permissions for administrators and customers.

---

# Sample Wallet Report

```
Digital Wallet Report

----------------------------------

Registered Users : 125

Active Wallets : 118

Locked Wallets : 7

Total Wallet Balance : $850,000

Largest Wallet Balance : $52,000

Generated : 2026-07-27 10:45:12
```

---

# Enterprise Concepts Demonstrated

- Spring Boot
- Spring Security
- OAuth2 Authentication
- JWT Authentication
- Role-Based Access Control
- Multi-Factor Authentication
- Redis Caching
- API Rate Limiting
- Session Management
- Fraud Detection
- Digital Wallet Architecture
- REST API Development
- Layered Architecture
- Repository Pattern
- Object-Oriented Programming

---

# Future Enhancements

- MySQL Database Integration
- Spring Data JPA
- Redis Server Integration
- Google Authenticator MFA
- QR Code Payments
- UPI Integration
- Payment Gateway Integration
- Kafka Event Streaming
- Docker Deployment
- Kubernetes
- Spring Cloud Config
- API Gateway
- Service Discovery
- Notification Service
- Email Alerts
- SMS Alerts
- Transaction History
- Swagger/OpenAPI
- JUnit & Mockito
- Jenkins CI/CD

---

# Learning Outcomes

This project demonstrates practical implementation of

- Java Enterprise Development
- Spring Boot REST APIs
- Spring Security
- OAuth2
- JWT Authentication
- Role-Based Access Control
- Multi-Factor Authentication
- Redis Session Management
- Fraud Detection Techniques
- Digital Payment Systems
- Secure REST API Design
- Enterprise Layered Architecture

---

## Author

**Poojitha Kanuri**

Java Full Stack Developer

Email: poojithakanuri03@gmail.com

LinkedIn: https://linkedin.com/in/poojithakanuri

GitHub: https://github.com/poojithak2503
