# Web_Based_Quiz

## Introduction

This is a web-based quiz application developed using Spring Boot and PostgreSQL. The application allows users to create, update, delete, and search questions. It also allows users to generate quizzes, take quizzes, and check their scores.

## Features

- **CRUD Operations on Questions**: Create, Read, Update, Delete questions.
- **Quiz Generation**: Generate quizzes based on selected criteria.
- **Taking Quizzes**: Users can take quizzes and submit their answers.
- **Score Calculation**: Automatically calculate and display user scores after quiz submission.
- **Postman Collection**: Postman collection is provided for API testing.

## Technologies Used

- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **API Testing**: Postman

## Prerequisites

- Java 17 or later
- PostgreSQL
- Maven
- Postman (optional, for testing)

## Setup Instructions

### Clone the Repository

```sh
git clone https://github.com/your-username/quiz-app.git
cd quiz-app
Database Configuration
Create a PostgreSQL database named quizdb.
Update the application.properties file located in src/main/resources with your database configuration:
properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/quizdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Build and Run the Application

mvn clean install
mvn spring-boot:run
The application will start on http://localhost:8080.

API Endpoints
Question Endpoints
Create Question

URL: /questions
Method: POST
Body:
json

{
  "questionTitle": "What is Java?",
  "option1": "A programming language",
  "option2": "A coffee type",
  "option3": "A car brand",
  "option4": "A planet",
  "rightAnswer": "A programming language",
  "difficultyLevel": "Easy",
  "category": "Programming"
}
Get All Questions

URL: /questions
Method: GET
Get Question by ID

URL: /questions/{id}
Method: GET
Update Question

URL: /questions/{id}
Method: PUT
Body: (same as create)
Delete Question

URL: /questions/{id}
Method: DELETE
Quiz Endpoints
Generate Quiz

URL: /quizzes/generate
Method: POST
Body:
json

{
  "numberOfQuestions": 10,
  "category": "Programming",
  "difficultyLevel": "Easy"
}
Submit Quiz and Get Score

URL: /quizzes/submit
Method: POST
Body:
json
{
  "quizId": 1,
  "answers": {
    "1": "A programming language",
    "2": "A coffee type",
    // ...
  }
}
Postman Collection
A Postman collection is provided for easier testing of the API endpoints. Import the collection from the file postman_collection.json located in the root of the project.

Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.


Contact
If you have any questions or suggestions, feel free to reach out to me at [your-email@example.com].

