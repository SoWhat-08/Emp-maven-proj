# Employee Management

Small Spring Boot + Maven project for Git, Jenkins and Docker CI/CD practice.

## APIs

GET    /employees
GET    /employees/{id}
POST   /employees
PUT    /employees/{id}
DELETE /employees/{id}

## Build

mvn clean test
mvn package

## Run

java -jar target/employee-management-1.0.0.jar

## Docker

docker build -t employee-management:latest .
docker run -d --name employee-app -p 8080:8080 employee-management:latest

## Git branch scenario

main
  |
develop
  |-- developer-a  -> Employee API
  |-- developer-b  -> Employee service
  |-- developer-c  -> Database/application configuration

Merge all branches into develop and resolve the intentional conflict before Jenkins deployment.
