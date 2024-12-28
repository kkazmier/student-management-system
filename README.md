# Student Management System

This repository contains a **Student Management System**, a web-based application developed using **Spring Boot**, **Thymeleaf**, and **SQLite**. The system allows users to manage student records effectively, including adding, editing, deleting, and viewing student details.

## Features
- View a list of students with their details.
- Add new students.
- Edit existing student records.
- Delete student records.
- Calculate the average grade of all students.

## Technology Stack
- **Backend**: Spring Boot
- **Frontend**: Thymeleaf
- **Database**: SQLite
- **Build Tool**: Maven

## Prerequisites
- Java Development Kit (JDK) 17 or higher
- Maven
- SQLite Studio (optional for database management)
- An IDE such as IntelliJ IDEA Ultimate

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/kkazmier/student-management-system.git
   cd student-management-system
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**
   Open your web browser and go to `http://localhost:8080`.

## Usage

1. **Homepage:**
   The homepage displays a list of all students. You can also see options to add a new student, calculate the average grade, and perform actions like editing or deleting a student.

2. **Add a Student:**
   Click the "Add Student" button and fill out the form with the student's details.

3. **Edit a Student:**
   Click the "Edit" button next to a student's record to update their information.

4. **Delete a Student:**
   Click the "Delete" button next to a student's record to remove them from the system.

5. **Calculate Average Grade:**
   Click the "Calculate Average" button to display the average grade of all students in the system.

## Project Structure
```
student-management-system
├── src
│   ├── main
│   │   ├── java
│   │   │   └── pl.edu.student_management_system
│   │   │       ├── controller   # Controllers for handling HTTP requests
│   │   │       ├── model        # Entity classes representing the database structure
│   │   │       ├── repository   # Repositories for database interactions
│   │   │       └── service      # Business logic for the application
│   │   └── resources
│   │       ├── templates        # Thymeleaf templates for UI
│   │       └── application.properties  # Configuration for the application
└── pom.xml                       # Maven configuration file
```

## Database Schema
The application uses an SQLite database with the following schema:

| Column   | Type        | Description         |
|----------|-------------|---------------------|
| `id`     | `INTEGER`   | Primary Key         |
| `name`   | `TEXT`      | Student's name      |
| `age`    | `INTEGER`   | Student's age       |
| `grade`  | `REAL`      | Student's grade     |

## Contributing
Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
