# Food Order Application

## Overview
This application is a simple food order service developed using Java, Spring Boot, PostgreSQL, and Hibernate ORM. It provides REST APIs for basic CRUD operations on food items and orders.

## Tech Stack
- Java 17
- Spring Boot
- Hibernate
- Maven
- PostgreSQL
- H2 in-memory database for testing
- MockMVC for integration tests
- JUnit and Mockito for unit tests

## Application Structure
The application follows a typical MVC structure with separate layers for Entities, DTOs, Repositories, Services, and Controllers. Exception handling is done globally with the help of a custom `@ControllerAdvice` class.

## Setup and Installation

1. Clone the repository:
    ```
    git clone https://github.com/andreigabriel10/Food-OrderApp.git
    ```
2. Change into the project directory:
    ```
    cd food-orderapp-application
    ```
3. Update the `application.properties` file under `src/main/resources` with your PostgreSQL credentials.
4. Build the application:
    ```
    mvn clean install
    ```
5. Run the application:
    ```
    mvn spring-boot:run
    ```
## API Usage

1. @RequestMapping("/api/products"): This annotation is used at the class level to map incoming HTTP requests with a specified URL path to this controller.
2. @GetMapping("/filter"): This method handles GET requests on "/api/products/filter" and it filters products based on name, description, price, and ingredients. All of these parameters are optional due to required = false. The filtering is performed in the ProductService, and the method returns a list of ProductDTO objects wrapped in an HTTP 200 OK response.
3. @DeleteMapping("/{id}"): This method handles DELETE requests on "/api/products/{id}". It deletes the product with the provided id. The id to delete is taken from the path of the request. A log message is written when a product is deleted.
4. @GetMapping: This method handles GET requests on "/api/products" and retrieves all products. The retrieval is performed by the ProductService, and the method returns a list of ProductDTO objects wrapped in an HTTP 200 OK response. It also logs that the products were retrieved.
5. @RequestMapping("/api/customers"): This annotation is used to map web requests onto specific handler classes or handler methods. In this case, it's used at the class level, meaning all methods within this controller will have a URL that starts with "/api/customers".
