# REST API for E-commerce Application

## Overview
This REST API for an E-commerce application is designed to provide a robust backend service with essential functionalities for managing products, users, and orders. The current implementation includes basic CRUD operations and is built using Spring Boot with a monolithic architecture. Future enhancements will integrate advanced features like security, payment gateway, and deployment automation.

## Technologies Used
- **Backend:** Spring Boot, Node.js
- **Database:** MongoDB
- **Security:** Keycloak (Spring Security)
- **Deployment:** AWS, GitHub Actions, Docker

## Features
- **CRUD Operations:** Basic Create, Read, Update, and Delete operations for products, users, and orders.
- **Spring Security Integration:** Planned integration with Keycloak for robust security.
- **Payment Gateway Integration:** Planned integration with a secure payment gateway.
- **Microservices Architecture:** Future implementation of microservices to connect Node.js applications with MongoDB.
- **Deployment Automation:** Use of GitHub Actions for CI/CD and deployment on AWS.

<!--- ## Installation

### Prerequisites
- Java (JDK 11+)
- Node.js
- MongoDB
- Docker
- AWS CLI

### Steps
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/ecommerce-api.git
   cd ecommerce-api
   ```

2. **Backend Setup:**
   - Navigate to the Spring Boot backend directory.
     ```bash
     cd backend
     ```
   - Install Maven dependencies.
     ```bash
     mvn clean install
     ```
   - Update the `application.properties` file with your MongoDB URI.
     ```properties
     spring.data.mongodb.uri=your_mongodb_uri
     ```

3. **Run the Spring Boot Application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Microservices Setup (Node.js):**
   - Navigate to the Node.js microservices directory.
     ```bash
     cd microservices
     ```
   - Install Node.js dependencies.
     ```bash
     npm install
     ```

5. **Docker Setup:**
   - Build the Docker image.
     ```bash
     docker build -t ecommerce-api .
     ```

6. **Deployment on AWS:**
   - Ensure AWS CLI is configured and use GitHub Actions for CI/CD.

## Usage
- Access the API at `http://localhost:8080/api`

## Contribution
Feel free to contribute to the project by opening issues or submitting pull requests.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For any questions or inquiries, please contact [your email].

---

Feel free to customize the content further to match your specific details and preferences.
