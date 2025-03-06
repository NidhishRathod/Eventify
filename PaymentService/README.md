
---

## **PaymentService - Secure Payment Processing**  

```md
# PaymentService - Secure Payment Processing  

This microservice handles **transactions, subscriptions, and rewards**.

## 🚀 Features Implemented  
- ✅ **Payment Processing** – Handles secure transactions.  
- ✅ **Subscription Management** – Users can subscribe to premium plans.  
- ✅ **Reward System** – Users earn rewards for payments.  
- ✅ **Multi-Currency Support** – Supports payments in multiple currencies.  
- ✅ **Fraud Detection** – Detects suspicious transactions.  
- ✅ **Feign Client Support** – Communicates with `UserService`.  
- ✅ **Eureka Client (Service Discovery)** – Registers with Eureka Server.  

## 🔧 Technologies Used  
- **Spring Boot**  
- **Spring Data JPA (MySQL Database)**  
- **Spring Cloud Feign Client**  
- **Eureka Client (Service Discovery)**  

## ⚙️ API Endpoints  
| HTTP Method | Endpoint | Description |
|-------------|---------|------------|
| `POST` | `/payments/process` | Process a new payment |
| `GET` | `/payments/user/{userId}` | Get user payment history |
| `POST` | `/payments/subscribe/{userId}` | Subscribe to a premium plan |
| `GET` | `/payments/rewards/{userId}` | Get user reward points |

## 🔄 How to Run  
1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/PaymentService.git
