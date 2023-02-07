# Web project based on Udemy 
<div align="center">
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" width="128" />
</div>


## Features

### Database tables
- [x] Categories
- [x] Courses
- [x] Sections
- [x] Videos

## Requirements

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Spring](https://spring.io/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Running the application

### Docker

```bash
docker-compose up
```

### Spring boot application

```bash
$ mvn spring-boot:run or ./mvnw spring-boot:run
$ mvn clean package -DskipTests or ./mvnw clean package -DskipTests 
$ java -jar JAR_FILE_NAME.jar
```



## Environment variables

- Application-dev.yml
```yml
spring:
  config:
    import: optional:file:.env.[.properties]
  datasource:
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    url: jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    show-sql: false
server:
  error:
    include-message: always
    include-stacktrace: never
  port: 8080
 ```


## Postman API testing


[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/1b1b1b1b1b1b1b1b1b1b)

**THE REQUEST MUST BE SENT IN JSON FORMAT**
- [x] [Get postman](https://www.postman.com/)
- [x] [Postman Collection](postman/Courses-api.postman_collection.json)

### Endpoints Postman image

<img src="postman/doc.png" alt="First endpoints image">
