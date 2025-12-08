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
- [3. System Architecture](#3-system-architecture)
  - [3.1 Backend (Spring Boot)](#31-backend-spring-boot)
  - [3.2 Frontend (React)](#32-frontend-react)
  - [3.3 Machine Learning Model](#33-machine-learning-model)
- [4. Domain Model](#4-domain-model)
  - [4.1 Person / Owner / Reviewer](#41-person--owner--reviewer)
  - [4.2 Apartment](#42-apartment)
  - [4.3 Review](#43-review)
- [5. REST API Endpoints](#5-rest-api-endpoints)
- [6. UML Diagram](#6-uml-diagram)
- [7. Entity–Relationship Diagram](#7-entityrelationship-diagram)
- [8. Technical Documentation](#8-technical-documentation)
  - [8.1 Lombok](#81-lombok)
  - [8.2 H2 Database](#82-h2-database)
  - [8.3 JPA](#83-jpa)
  - [8.4 JUnit](#84-junit)
  - [8.5 MVC Architecture](#85-mvc-architecture)
- [9. Installation & Setup](#9-installation--setup)
- [10. Project Status](#10-project-status)
- [11. Roadmap](#11-roadmap)
- [12. Credits & Dataset](#12-credits--dataset)

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

## 3. System Architecture

### 3.1 Backend (Spring Boot)

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

### 3.2 Frontend (React)

Key responsibilities:

- Apartment form for ML predictions  
- CRUD interfaces for Apartments & Reviews  
- Responsive design  

📄 Extended documentation: `/docs/react.md`

---

### 3.3 Machine Learning Model

- Regularized regression (Ridge / Lasso)  
- Handles strong multicollinearity  
- Trained on a small Kaggle housing dataset  
- Exposed via REST endpoint  

📄 Extended documentation: `/docs/ml-model.md`

---

## 4. Domain Model

### 4.1 Person / Owner / Reviewer

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
