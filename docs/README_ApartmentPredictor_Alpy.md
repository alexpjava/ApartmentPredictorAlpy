# ApartmentPredictor_Alpy --- Backend Documentation

## Overview

**ApartmentPredictor_Alpy** is a Java Spring Boot backend designed to
manage apartments, owners, reviewers, and their associated reviews.\
Additionally, the project integrates a machine‑learning--based price
prediction module trained on a housing dataset to estimate rental or
sale prices based on property characteristics.

This project aims to serve both as a scalable backend architecture and
as a learning tool for mastering Java, Spring Boot, data persistence,
and applied machine learning.

------------------------------------------------------------------------

## Key Features

### ✔ MVC Architecture

-   **Model**: JPA entities representing Apartments, Owners, Reviewers,
    and Reviews.\
-   **View**: Basic Thymeleaf support (optional UI).
-   **Controller**: REST API for CRUD operations.

### ✔ Inheritance Model

-   `Person` (abstract) → `Owner` and `Reviewer`.

### ✔ Price Prediction Engine

-   Uses the provided **Housing.csv** dataset to train a basic
    regression‑based predictor.
-   Offers REST endpoints to request predicted prices based on apartment
    attributes.
-   Designed for easy future upgrades to more advanced ML tools.

### ✔ Technologies

-   **Java 21**
-   **Spring Boot**
-   **Spring Web**
-   **Spring Data JPA**
-   **H2 Database**
-   **Lombok**
-   **Thymeleaf**
-   **JUnit**
-   **Maven**

------------------------------------------------------------------------

## Project Structure

    src/main/java/com/example/apartmentpredictor
    │
    ├── entities
    │   ├── Person.java
    │   ├── Owner.java
    │   ├── Reviewer.java
    │   ├── Apartment.java
    │   └── Review.java
    │
    ├── controllers
    │   ├── ApartmentController.java
    │   ├── OwnerController.java
    │   ├── ReviewerController.java
    │   ├── ReviewController.java
    │   └── PricePredictionController.java
    │
    ├── services
    │   ├── ApartmentService.java
    │   ├── OwnerService.java
    │   ├── ReviewerService.java
    │   ├── ReviewService.java
    │   └── PricePredictionService.java
    │
    └── utils
        └── DataLoader.java

------------------------------------------------------------------------

## Dataset

The backend uses the dataset provided in:

    /src/main/resources/data/Housing.csv

The data loader: - Reads on startup - Inserts sample apartments into
H2 - Uses the dataset for ML training

Dataset references: - Kaggle Housing Dataset\
- Clean CSV versions aligned with project attributes

------------------------------------------------------------------------

## Installation

### 1. Clone the repository

    git clone https://github.com/<your-username>/ApartmentPredictor_Alpy.git
    cd ApartmentPredictor_Alpy

### 2. Build using Maven

    mvn clean install

### 3. Run the application

    mvn spring-boot:run

### 4. H2 Database Console

Accessible at:

    http://localhost:8080/h2-console

Default configuration:

    JDBC URL: jdbc:h2:mem:testdb
    User: sa
    Password: (empty)

------------------------------------------------------------------------

## API Endpoints

### Apartments

  Method   Endpoint                    Description
  -------- --------------------------- -------------------------
  GET      `/api/apartments`           List all apartments
  POST     `/api/apartments`           Create new apartment
  GET      `/api/apartments/{id}`      Get apartment by ID
  PUT      `/api/apartments/{id}`      Update apartment
  DELETE   `/api/apartments/{id}`      Delete apartment
  POST     `/api/apartments/predict`   Predict apartment price

### Owners / Reviewers

Basic CRUD for: - `/api/owners` - `/api/reviewers`

### Reviews

-   `/api/apartments/{id}/reviews` --- list / create reviews

------------------------------------------------------------------------

## Price Prediction Engine

The `PricePredictionService`: - Loads CSV data - Trains a simple
regression/heuristic model - Exposes `/api/predict`

Example Request:

``` json
{
  "area": 1200,
  "bedrooms": 3,
  "bathrooms": 2,
  "furnishingStatus": "FURNISHED",
  "mainroad": true,
  "parking": 1,
  "prefarea": false
}
```

Example Response:

``` json
{
  "predictedPrice": 112500
}
```

------------------------------------------------------------------------

## Running Tests

    mvn test

Includes: - Unit tests for services - Integration test with H2
database - Prediction model test

------------------------------------------------------------------------

## Roadmap

-   Add JWT authentication
-   Add Pagination + Sorting
-   Improve ML model using Smile or external Python microservice
-   Add Docker support
-   Add Swagger / OpenAPI documentation
-   Build full frontend (React)

------------------------------------------------------------------------

## License

This project is open-source and available for educational and practical
use.\
See the LICENSE file for more details.

------------------------------------------------------------------------

## Author

Developed as part of the **ApartmentPredictor** learning project.\
Contributions and improvements are welcome!
