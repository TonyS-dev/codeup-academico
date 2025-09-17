# Academic - Student Management Desktop Application

A modern, desktop-based application for managing students, grades, and authentication. Built with Java Swing, SQLite for persistence, and secure password handling via bcrypt.

---

## 🖥️ Demo

Run locally on your machine (see instructions below).

---

## 🛠️ Tech Stack

- **Java 17**: Main programming language
- **Swing**: GUI framework for desktop applications
- **SQLite**: Embedded relational database
- **JDBC**: Database connectivity
- **jBCrypt**: Password hashing and verification
- **AbsoluteLayout**: UI layout manager (NetBeans)
- **Maven**: Build and dependency management

---

## 📁 Project Structure

```
academic/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/codeup/academic/
│   │   │   │   ├── App.java                # Entry point
│   │   │   │   ├── domain/                 # Core domain models (Student, User, Grade, etc.)
│   │   │   │   ├── service/                # Business logic (RegisterStudent, UserService, File, etc.)
│   │   │   │   ├── ui/                     # Swing UI frames (SignFrame, RegisterStudentFrame)
│   │   │   │   └── util/                   # Utilities (Validation, PasswordUtils)
│   │   ├── resources/
│   │   │   └── data/
│   │   │       └── students.csv            # Sample student data
├── pom.xml                                 # Maven build file
├── README.md                               # Project documentation
└── ...
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 17+** (JDK)
- **Maven** (for building)
- No external database required (uses embedded SQLite)

### How to Run

1. **Clone the repository:**
    ```bash
    git clone https://github.com/TonyS-dev/academic.git
    cd academic
    ```

2. **Build the project:**
    ```bash
    mvn clean package
    ```

3. **Run the application:**
    ```bash
    java -jar target/academic-app.jar
    ```
---

## ✅ Core Features

- **User Authentication:** Secure login and registration with hashed passwords.
- **Student Management:** Add, import, export, and view students and their grades.
- **Statistics:** Calculate averages, best students, and approval rates.
- **CSV Import/Export:** Easily import/export student data.
- **Role System:** Default admin and teacher roles.
- **Input Validation:** Robust checks for all user and student fields.

---

## 🌱 Environment & Configuration

- **Database:** Uses `academic.db` (SQLite) in the project root.
- **Default Admin User:** Created automatically if no users exist.
    - Username: `admin`
    - Password: `admin123`
- **Student Data:** Example CSV at `src/main/resources/data/students.csv`

---

## 👤 Default Users

- **Admin:**
    - Username: `admin`
    - Password: `admin123`

---

## 👨‍💻 Author

- **Name:** Antonio Santiago
- **GitHub:** [TonyS-dev](https://github.com/TonyS-dev)
- **Email:** santiagor.acarlos@gmail.com

---
