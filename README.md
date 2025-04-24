# Quiz_App
QuizApp - Monolithic Spring Boot Application
QuizApp is a monolithic Spring Boot application designed to manage quizzes and questions. Users can retrieve quizzes, and the system internally fetches associated questions.
Features
•	• Fetch quizzes by ID
•	• Internal communication to retrieve questions
•	• Returns list of wrapped questions for a quiz
•	• Built as a monolithic Spring Boot application
Technologies Used
•	• Java 17+
•	• Spring Boot
•	• Spring Web
•	• Spring Data JPA
•	• PostgreSQL
•	• Maven
Project Structure

com.quizapp
├── controller
├── service
├── repository
├── model
└── main

API Endpoints
POST /quiz/create
Response:
• 200 OK – Quiz and its questions retrieved
• 404 Not Found – If quiz not found
Sample Response

[
  {
    "id": 1,
    "questionTitle": "What is OOP?",
    "category": "java",
    "difficultyLevel": "easy",
    "options1": "Object-Oriented Programming",
    "options2": "Online Open Protocol",
    "options3": "Other Option",
    "options4": "None",
    "rightAnswer": "Object-Oriented Programming"
  }
]

Setup Instructions
1. Clone the Repository
git clone https://github.com/your-username/quizapp.git
cd quizapp
2. Configure the Database
Edit src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:3306/Yourdatabase
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3. Run the Application
./mvnw spring-boot:run
4. Access the Application
Base URL: http://localhost:8080
Contribution
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

