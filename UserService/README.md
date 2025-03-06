# UserService - Authentication & User Management  

This microservice handles **user registration, authentication, and authorization**.

## 🚀 Features Implemented  
- ✅ **User Registration** – Users can register with username, password, and other details.  
- ✅ **User Authentication** – Secure authentication using **Spring Security**.  
- ✅ **Role-Based Access Control (RBAC)** – `USER` and `ADMIN` roles for controlled access.  
- ✅ **JWT Token Support** – Secure authentication with JSON Web Token (JWT).  
- ✅ **User Retrieval** – Fetch user details by `username` or `ID`.  
- ✅ **Feign Client Support** – Communicates with `PaymentService` & `EventService`.  

## 🔧 Technologies Used  
- **Spring Boot**  
- **Spring Security (JWT Authentication)**  
- **Spring Data JPA (MySQL Database)**  
- **Spring Cloud Feign Client**  
- **Eureka Client (Service Discovery)**  

## ⚙️ API Endpoints  
| HTTP Method | Endpoint | Description |
|-------------|---------|------------|
| `POST` | `/users/register` | Register a new user |
| `GET` | `/users/{username}` | Get user details |
| `GET` | `/users/exists/{userId}` | Check if a user exists |

## 🔑 Security Configurations  
- Uses **JWT tokens** for secure authentication  
- **Basic Authentication** enabled for internal service-to-service communication  
- **Role-based authorization** to protect endpoints  

## 🔄 How to Run  
1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/UserService.git
