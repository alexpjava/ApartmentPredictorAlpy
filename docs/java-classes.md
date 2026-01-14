# Guide to Java Class Types

This document details the structures and roles that classes take within the Java ecosystem, covering everything from Java SE to enterprise frameworks.

---

## 0. Basic Class (Java SE) / Clase Básica
The fundamental unit of **Object-Oriented Programming**. It defines the "blueprint" or template for creating objects.

* **Purpose:** To define attributes (state) and methods (behavior).
* **Instantiation:** Objects are created using the `new` keyword.
* **Example:**
    ```java
    public class User {
        String name;
        // Constructor and methods...
    }
    ```

## 1. Static Class (Java SE) / Clase Static
Generally refers to **static nested classes** or utility classes that do not need to be instantiated to access their members.

* **Characteristics:** Its methods and variables are accessed directly through the class name.
* **Common Use:** Utility classes (like `java.lang.Math`).
* **Key Fact:** A top-level class cannot be static, but its members can.

## 2. Interfaces, Abstract Classes, and Inheritance / Interfaces y Herencia
They define the hierarchy and behavior of the system.

* **Interfaces:** Contracts that define *what* a class must do (using `implements`).
* **Abstract Classes:** Classes that cannot be instantiated; they serve as a partial base for other classes (using `extends`).
* **Inheritance:** A mechanism to reuse code from a parent class in a child class.

## 3. @Entity Classes (Java EE / Jakarta EE)
Classes linked to data persistence through **JPA (Java Persistence API)**.

* **Function:** Each instance of this class represents a row in a database table.
* **Requirement:** Must have the `@Entity` annotation and a primary key marked with `@Id`.

## 4. Classes with Annotations (e.g., @Service) / Clases con Anotaciones
Used in environments like the **Spring Framework** for component management and Dependency Injection.

* **@Service:** Marks a class that contains business logic.
* **@Repository:** For classes that handle database communication.
* **@Controller:** For managing HTTP requests.
* **Benefit:** The developer doesn't create the object with `new`; instead, the framework manages it automatically.

---

## Summary of the Hierarchy

```mermaid
graph TD
    %% Main Node
    A[Java Class Types] --> SE[Java SE: Fundamentals]
    A --> EE[Jakarta EE / Spring: Enterprise]

    %% Java SE
    subgraph "Java SE (Standard Edition)"
    SE --> SE1[Basic Class]
    SE1 --> SE1_1(Objects via 'new')
    
    SE --> SE2[Static Class]
    SE2 --> SE2_1(Utilities / Class-level methods)
    
    SE --> SE3[Abstraction]
    SE3 --> SE3_1[Interfaces]
    SE3 --> SE3_2[Abstract Classes]
    SE3 --> SE3_3[Inheritance]
    end

    %% Java EE / Spring
    subgraph "Frameworks / JEE"
    EE --> EE1["@Entity (JPA)"]
    EE1 --> EE1_1(Database Mapping)
    
    EE --> EE2["Annotations (@Service)"]
    EE2 --> EE2_1(Dependency Injection)
    EE2 --> EE2_2(Container Managed)
    end

    %% Styles
    style A fill:#f9f,stroke:#333,stroke-width:2px
    style SE fill:#bbf,stroke:#333
    style EE fill:#bfb,stroke:#333
``````
---
  [⬅️ Back to Index](../README.md#table-of-contents)