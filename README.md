# 🏠 Housing Price Predictor — Full-Stack Application (Java 21, Spring Boot, React)

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-blue" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen" />
  <img src="https://img.shields.io/badge/React-18.x-61DAFB" />
  <img src="https://img.shields.io/badge/Status-In%20Development-orange" />
</p>

A full-stack application for managing apartments, owners, reviewers, and reviews, enhanced with a machine-learning model capable of predicting apartment prices based on multiple features.  
Designed as a scalable educational project to document concepts such as Spring Boot, JPA, MVC, ML integration, and React.

---

## 📚 Table of Contents

- [1. Project Overview](#1-project-overview)
- [2. Product Goal](#2-product-goal)
- [3. Project Structure](#3-project-structure)

- [3. System Architecture](#3-system-architecture)
  - [4.1 Backend (Spring Boot)](#41-backend-spring-boot)
  - [4.2 Frontend (React)](#42-frontend-react)
  - [4.3 Machine Learning Model](#43-machine-learning-model)
- [5. Domain Model](#5-domain-model)
  - [5.1 Person / Owner / Reviewer](#51-person--owner--reviewer)
  - [5.2 Apartment](#52-apartment)
  - [5.3 Review](#53-review)
- [6. REST API Endpoints](#6-rest-api-endpoints)
- [7. UML Diagram](#7-uml-diagram)
- [7. UML Diagram & notes](docs/uml-notes.md)
- [8. Entity–Relationship Diagram](#8-entityrelationship-diagram)
- [9. Technical Documentation](#9-technical-documentation)
  - [9.1 Lombok](#91-lombok)
  - [9.2 H2 Database](#92-h2-database)
  - [9.3 JPA](#93-jpa)
  - [9.4 JUnit](#94-junit)
  - [9.5 MVC Architecture](#95-mvc-architecture)
  - [9.6 CsvToH2](#96-CsvToH2)
  - [9.7 Java Classes](#97-java-classes)
- [10. Installation & Setup](#10-installation--setup)
- [11. Project Status](#11-project-status)
- [12. Roadmap](#12-roadmap)
- [13. Credits & Dataset](#13-credits--dataset)

---

## 1. Project Overview

This project is a **full-stack learning application** built with **Java 21 + Spring Boot (backend)** and **React (frontend)**.  
It allows owners and reviewers to register, create apartments, submit reviews, and generate machine-learning-based **price predictions** using a regression model trained on a housing dataset from Kaggle.

This repository also serves as a **documentation-friendly environment**:  
each architectural layer, technology, and relevant concept will be explained in individual Markdown files under `/docs`.

---

## 2. Product Goal

The application must support CRUD operations for:

- **Owners**
- **Reviewers**
- **Apartments**
- **Reviews**

When creating a new apartment, a trained **regularized regression model** will automatically generate a **market price prediction** based on attributes such as:

- Area  
- Number of bedrooms  
- Number of bathrooms  
- Furnishing status  
- Proximity to the main road  
- Additional amenities  

The full-stack objective includes:

- A **RESTful Spring Boot API** (CRUD + prediction endpoints)
- A **React UI** to create, edit, list, and delete apartments and reviews
- A **responsive, minimalistic interface**
- Clear documentation of backend, frontend, and ML workflows


---

## 3. Project Structure

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

---

## 4. System Architecture

### 4.1 Backend (Spring Boot)

**Core dependencies:**

- Spring Web  
- Spring Data JPA  
- Lombok  
- Spring Boot DevTools  
- Thymeleaf  
- H2 Database  

📄 Extended documentation:  
- `/docs/spring-boot.md`  
- `/docs/jpa.md`  
- `/docs/lombok.md`  
- `/docs/mvc.md`  

---

### 4.2 Frontend (React)

Key responsibilities:

- Apartment form for ML predictions  
- CRUD interfaces for Apartments & Reviews  
- Responsive design  

📄 Extended documentation: `/docs/react.md`

---

### 4.3 Machine Learning Model

- Regularized regression (Ridge / Lasso)  
- Handles strong multicollinearity  
- Trained on a small Kaggle housing dataset  
- Exposed via REST endpoint  

📄 Extended documentation: `/docs/ml-model.md`

📄 Extended documentation: `/docs/java_XGBoost_via_Tribuo_Price_Predictor.md`
[⬅️ java XGBoost via Tribuo Pridictor](/docs/java_XGBoost_via_Tribuo_Price_Predictor.md)

---

## 5. Domain Model

### 5.1 Person / Owner / Reviewer

```java
Person:
- id
- name
- email
- age

Owner extends Person:
- isActive
- isBusiness
- idLegalOwner
- registrationDate
- qtyDaysAsOwner
- List<Apartment> apartments

Reviewer extends Person:
- List<Review> reviews

Apartment:
- id
- price (predicted by ML model)
- area
- bedrooms
- bathrooms
- stories
- mainroad
- guestroom
- basement
- hotwater
- heating
- airconditioning
- parking
- prefarea
- furnishingstatus
- Owner owner
- List<Review> reviews
```
---

 
## 6. REST API Endpoints

### 6.1 Request Response Cycle

- Request Response Cycle. 

📄 Extended documentation:  
- `/docs/java_XGBoost_via_Tribuo_Price_Predictor.md`  
