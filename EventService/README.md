
---

## **EventService - Event Management System**  

```md
# EventService - Event Management System  

This microservice handles **event creation, user participation, and event details**.

## 🚀 Features Implemented  
- ✅ **Create, Update, and Delete Events** – Full CRUD operations.  
- ✅ **Fetch Event Details** – Users can view event details.  
- ✅ **User Registration for Events** – Users can register for events.  
- ✅ **Event Verification** – Check if a user is registered for an event.  
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
| `POST` | `/events` | Create a new event |
| `GET` | `/events/{eventId}` | Get event details |
| `POST` | `/events/register/{eventId}/{userId}` | Register user for event |
| `GET` | `/events/user/{userId}` | Get events registered by user |

## 🔄 How to Run  
1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/EventService.git
