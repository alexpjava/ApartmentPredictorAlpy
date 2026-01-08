# Guía de Tipos de Clases en Java

Este documento detalla las estructuras y roles que adoptan las clases en el ecosistema Java, cubriendo desde Java SE hasta frameworks empresariales.

---

## 0. Clase Básica (Java SE)
Es la unidad fundamental para la **Programación Orientada a Objetos**. Define el "plano" o molde para crear objetos.

* **Propósito:** Definir atributos (estado) y métodos (comportamiento).
* **Instanciación:** Se crean mediante el operador `new`.
* **Ejemplo:**
    ```java
    public class Usuario {
        String nombre;
        // Constructor y métodos...
    }
    ```

## 1. Clase Static (Java SE)
Generalmente se refiere a **clases internas estáticas** o clases de utilidad que no necesitan ser instanciadas para acceder a sus miembros.

* **Características:** Sus métodos y variables se acceden directamente a través del nombre de la clase.
* **Uso común:** Clases de utilidad (como `java.lang.Math`).
* **Dato clave:** Una clase "top-level" no puede ser estática, pero sus miembros sí.

## 2. Interfaces, Clases Abstractas y Herencia
Definen la jerarquía y el comportamiento del sistema.

* **Interfaces:** Son contratos que definen *qué* debe hacer una clase (usando `implements`).
* **Clases Abstractas:** Clases que no se pueden instanciar; sirven como base parcial para otras clases (usando `extends`).
* **Herencia:** Mecanismo para reutilizar código de una clase padre en una clase hija.



## 3. Clases @Entity (Java EE / Jakarta EE)
Son clases vinculadas a la persistencia de datos mediante **JPA (Java Persistence API)**.

* **Función:** Cada instancia de esta clase representa una fila en una tabla de la base de datos.
* **Requisito:** Deben tener la anotación `@Entity` y una clave primaria marcada con `@Id`.

## 4. Clases con Anotaciones (Ejemplo @Service)
Utilizadas en entornos como **Spring Framework** para la gestión de componentes y la Inyección de Dependencias.

* **@Service:** Marca una clase que contiene la lógica de negocio.
* **@Repository:** Para clases que manejan la comunicación con la base de datos.
* **@Controller:** Para gestionar peticiones HTTP.
* **Beneficio:** El desarrollador no crea el objeto con `new`, sino que el framework lo gestiona automáticamente.

---
*Apuntes creados para fines educativos - 2026*