# Notepad API

A simple RESTful **Notepad API** built with **Java**, **Spring Boot**, and **H2 Database**.  
This project allows users to create, read, update, and delete notes, while also keeping track of edit history.

## Features

- Create new notes
- Get all notes
- Get note by ID
- Update existing notes
- Delete notes
- Store edit history for notes
- In-memory H2 database for easy development and testing
- RESTful API design

## Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

## Project Structure

```bash
src
├── main
│   ├── java
│   │   └── com.example.notepad_api
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── model
│   │       └── dto
│   └── resources
│       ├── application.yml
│       └── data.sql
```


---

## 🔗 API Endpoints

### 📌 Notes

| Method | Endpoint        | Description       |
|--------|----------------|-------------------|
| GET    | `/notes`       | Get all notes     |
| GET    | `/notes/{id}`  | Get note by ID    |
| POST   | `/notes`       | Create new note   |
| PUT    | `/notes/{id}`  | Update note       |
| DELETE | `/notes/{id}`  | Delete note       |

---
