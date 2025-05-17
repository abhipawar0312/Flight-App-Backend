# Flight-App-Backend
# ✈️ Flight Backend API

This is a Spring Boot-based backend service for managing flight-related data such as flights, companies, booking classes, and criteria-based flight search.

## 📦 Features

- Manage flights and companies
- Flight search with criteria (company, flight type, travel type)
- Cabin class and baggage details
- RESTful API endpoints
- JPA with Criteria API for dynamic queries
- Enum-based input validation

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Gradle
- Lombok 
- Swagger (optional for API docs)
  

---




## 🛠️ Setup Instructions

### Prerequisites

- Java 17+
- Gradle
- MySQL
- Postman / Curl for testing (optional)

### Running Locally

1. **Clone the repo**

[git clone https://github.com/yourusername/flight-backend.git](https://github.com/abhipawar0312/Flight-App-Backend.git)


Update application.properties

properties

spring.datasource.url=jdbc:mysql://localhost:3306/flight_app
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Build and Run
./gradlew bootRun


API End Points
| Method | Endpoint              | Description                      |
| ------ | --------------------- | -------------------------------- |
| `POST` | `/api/flights/search` | Search flights based on criteria |
| `GET`  | `/api/flights`        | List all flights                 |
| `POST` | `/api/flights`        | Create a new flight              |
| `GET`  | `/api/companies`      | List airline companies           |

