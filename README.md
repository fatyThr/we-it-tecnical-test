# we-it-tecnical-test

This repository contains the result of technical test, a microservice built for the REST API using hexagonal architecture, Spring Boot, and Java 21.

## Table of Contents

- [Description](#description)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Configuration](#configuration)
- [API Documentation](#api-documentation)

## Description

The project  is a microservice designed  to create, read and modify resources
For access to the project use :
Login : user
Password :password
## Getting Started

### Prerequisites

To run the we-it-tecnical-test Project, make sure you have the following installed on your system:
- Java Development Kit (JDK) 21
- Spring Boot 3.2.3
- Maven


#### Database Setup

-Create the H2 database:
Add dependency; 
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
### Installation

1.	Clone the repository:
      git clone https://github.com/fatyThr/we-it-tecnical-test.git
2.  Build the project using Maven:
> cd we-it-tecnical-test
> mvn clean install

### Configuration

To start the we-it-tecnical-test, use the following command:
> java -jar we-it-tecnical-test.jar
>
## API Documentation

For detailed information on available APIs and endpoints, refer to the API documentation at docs/api.md.

Swagger UI Documentation: http://localhost:8080/swagger-ui/index.html

 


