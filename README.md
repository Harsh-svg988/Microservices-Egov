# Water Connection Service

This project is a Spring Boot application for managing water connections. It includes functionalities for creating, updating, and searching water connection applications.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Database Migration](#database-migration)
- [Kafka Integration](#kafka-integration)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

- Java 17
- Maven
- Docker
- PostgreSQL

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-repo/water-connection.git
    cd water-connection
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## Configuration

The application configuration is managed through the [application.properties](http://_vscodecontentref_/1) file located in the [resources](http://_vscodecontentref_/2) directory. Key configurations include:

- **Server Configuration**
    ```properties
    server.port=8080
    app.timezone=UTC
    ```

- **Database Configuration**
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/birthregn
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    ```

- **Kafka Configuration**
    ```properties
    kafka.config.bootstrap_server_config=localhost:9092
    spring.kafka.consumer.group-id=birth-registration-group
    ```

## Running the Application

1. Start the required services using Docker Compose:
    ```sh
    docker-compose up -d
    ```

2. Run the Spring Boot application:
    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

- **Create Water Connection**
    ```http
    POST /connection/v1/_create
    ```

- **Search Water Connections**
    ```http
    POST /v1/connection/_search
    ```

- **Update Water Connection**
    ```http
    POST /connection/v1/_update
    ```

## Database Migration

Flyway is used for database migrations. The migration scripts are located in the [main](http://_vscodecontentref_/3) directory. To run the migrations, use the following command:
```sh
mvn flyway:migrate