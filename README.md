# BH Bank API 
The BH coding assignment to design and develop an API to be used for opening a new “current account” of already existing customers.
# Introduction
The application is developed with Java 11 and Spring Boot framework using Maven along with several third party libraries such as H2 DB, OpenAPI(Swagger), Liquibase, Spring AOP, Swagger-UI, Lombok etc.

# Thought Process
1. Use of microservices architecture using MVC pattern
2. Customer, Account and Transaction are in a single API but if scalability aspects are to be considered these three could be independent microservices communicating through REST endpoint calls
3. Docker could be used to containerize the application
4. Maven is used as a build tool for this project
5. Spring AOP is used in validators
6. H2 in-memory database is used for easy startup of application
7. JUnit and Mockito is used for Unit tests but only few tests are written
8. Liquibase is used as a database migration tool to setup db structure and insert customer records
9. Swagger-UI is used to expose the API as an HTML website making it easy to test and play  

# Prerequisites
1. Java 11 or above is required
2. Maven 3.5 or above is required. For details please visit: https://maven.apache.org/install.html

# Build and Test
 - Checkout code from GitHub to your local machine in a new folder by executing below commands from your favourite terminal

```mkdir new-folder```

```cd new-folder```

```git clone https://github.com/ax-rawblack/bh-bank-api.git```
 
 - To build application execute commands

```cd bh-bank-api```

```mvn clean install```

 - Once build completes execute following commands to run application

```cd service```

```mvn spring-boot:run```

- The application will start and can be confirmed running using actuator endpoint http://localhost:8080/actuator in your web browser
- Open http://localhost:8080/swagger-ui.html in your web browser and use 'Try it Out' to test the any endpoint providing necessary inputs
- API docs are available at http://localhost:8080/api-docs
- H2 db can be visualised at http://localhost:8080/h2-console using db details from application.yaml file in the project
