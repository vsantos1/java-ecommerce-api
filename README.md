# Web project with Spring Boot 
<div align="center">
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" width="128" />
</div>

## Project description
    - Spring Boot
    - Spring Security
    - Spring Data JPA
    - Spring Web
    - Spring Validation
    - Model Mapper
    - JWT
- [x] [Spring Boot](https://spring.io/projects/spring-boot)
- [x] [Spring Security](https://spring.io/projects/spring-security)
- [x] [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [x] [Spring Web](https://spring.io/projects/spring-framework)
- [x] [Spring Validation](https://spring.io/projects/spring-framework)
- [x] [Model Mapper](http://modelmapper.org/)
- [x] [JWT](https://jwt.io/)
- [x] [Cloudinary](https://cloudinary.com/)
- [x] [PostgreSQL](https://www.postgresql.org/)
- [x] [Docker](https://www.docker.com/)

## Requirements
- [x] [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [x] [Maven](https://maven.apache.org/)
- [x] [Docker](https://www.docker.com/)
- 
## Features

### Database tables
- [x] Categories
- [x] Products
- [x] Users with **JWT**
- [ ] Orders [**Unfinished**]
- [ ] Payments [**Unfinished**]

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
      ddl-auto: none
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    show-sql: false
server:
  error:
    include-message: always
    include-stacktrace: never
jwt:
  secret: ${JWT_SECRET}
file:
  upload:
    cloud-name: ${CLOUD_NAME}
    api-key: ${API_KEY}
    api-secret: ${API_SECRET}
 ```


## Postman API testing


[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/1b1b1b1b1b1b1b1b1b1b)

**THE REQUEST MUST BE SENT IN JSON FORMAT/MULTIPART FORM DATA**
- [x] [Get postman](https://www.postman.com/)

### Endpoints Postman image

<img src="https://boilingwaters.ph/wp-content/uploads/2021/06/51KUEBj37QL-696x488.jpg" alt="First endpoints image">
