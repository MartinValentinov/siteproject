# Student Help Platform

## Overview
This project is a **web application that helps students with school problems**.  
Students who need help can find other students (helpers) to assist them with tasks, homework, and test preparation.  

The platform aims to provide a safe and structured environment where learners can connect, communicate, and collaborate.

---

## Features (Planned)

### 1. User System
- Registration and login using **Spring Security** and **JWT tokens**  
- Two main user roles: **Student** and **Helper**  

### 2. Rating and Review System
- Students can leave **reviews and ratings** for helpers  
- Helpers can be sorted by **rating** and **subjects**  

### 3. Chat System
- Real-time chat between students and helpers using **WebSockets (STOMP)**  
- Messages stored in the database  
- Notifications for new messages  

### 4. Task Calendar
- **CRUD operations** for tasks (create, edit, delete)  
- Visual calendar for homework and tests  
- Reminders for upcoming events  

### 5. AI Assistant – Planner
- Integration with an external AI (e.g., **OpenAI API**)  
- Generates personalized study plans based on added tasks and tests  

### 6. AI Assistant – Essay Review
- Students can upload essays  
- Automatic checking for grammar, style, and structure  
- Feedback and suggestions for improvement  

---

## Technologies Used

- **Backend:** Spring Boot  
- **Security & Authentication:** Spring Security + JWT  
- **Real-time Chat:** WebSockets (STOMP)  
- **Database:** PostgreSQL (users, messages, reviews, tasks)  
- **Frontend:** React (or Vue/Angular)  
- **Containerization:** Docker  
- **Hosting:** Heroku / Railway / AWS (most likely AWS or Google Cloud)  
- **AI Features:** OpenAI API (or other LLM)  

> Note: Technology choices may evolve during development, but the overall project structure and functionality will remain consistent.

---

## Current Status

- Phase 3 is in progress  
- Core focus on **User System, Rating/Review, and Chat System**  
- Remaining features (Calendar, AI Planner, AI Essay Review) are planned for subsequent phases  
