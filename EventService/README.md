# EventService - Event Management System  

This microservice manages **events, user participation, AI-powered recommendations, and real-time event updates**.

## 🚀 Features Implemented  
- ✅ **Create, Update, and Delete Events** – Full CRUD operations.  
- ✅ **Fetch Event Details** – Users can view event details.  
- ✅ **User Registration for Events** – Users can register for events.  
- ✅ **Event Verification** – Check if a user is registered for an event.  
- ✅ **AI-Powered Event Recommendations** – Suggests events based on user interests & past activity.  
- ✅ **Live Event Updates using WebSockets** – Real-time event notifications.  
- ✅ **Feign Client Support** – Communicates with `UserService`.  
- ✅ **Eureka Client (Service Discovery)** – Registers with Eureka Server.  

## 🔧 Technologies Used  
- **Spring Boot**  
- **Spring Data JPA (MySQL Database)**  
- **Spring Cloud Feign Client**  
- **Eureka Client (Service Discovery)**  
- **WebSockets (Real-time updates)**  
- **AI Recommendation Engine (ML-based event suggestions)**  

## ⚙️ API Endpoints  
| HTTP Method | Endpoint | Description |
|-------------|---------|------------|
| `POST` | `/events` | Create a new event |
| `GET` | `/events/{eventId}` | Get event details |
| `POST` | `/events/register/{eventId}/{userId}` | Register user for event |
| `GET` | `/events/user/{userId}` | Get events registered by user |
| `GET` | `/events/recommend/{userId}` | Get AI-powered event recommendations |
| `GET` | `/events/live-updates` | Get real-time event updates via WebSockets |

## 📡 **AI-Powered Recommendations**  
- Uses **machine learning algorithms** to recommend events based on:  
  - User preferences  
  - Past event participation  
  - Trending events in similar categories  
  - Social engagement & activity patterns  

## 🔔 **Live Event Updates with WebSockets**  
- Sends **real-time event notifications** to registered users.  
- Uses **WebSockets** for instant communication.  
- Keeps users updated about **event schedule changes, last-minute announcements, and availability updates**.  

## 🔄 How to Run  
1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/EventService.git
