# 📑 Documentación Técnica: Ciclo Request-Response (Java Spring Boot)

Este documento explica cómo fluyen los datos a través de las capas de la aplicación, analizando el código específico del proyecto `Apartment` para definir exactamente qué hace cada parte.

---


```mermaid
sequenceDiagram
    autonumber
    participant Client as Cliente (Postman / Frontend)
    participant Controller as Controller
    participant Service as Service
    participant Repository as Repository
    participant DB as Base de Datos

    %% GET REQUEST FLOW
    Client->>Controller: GET /getById?id=UUID
    Controller->>Service: findApartmentById(id)
    Service->>Repository: findById(id)
    Repository->>DB: SELECT * FROM apartment WHERE id = ?
    DB-->>Repository: Fila Apartment
    Repository-->>Service: Apartment
    Service-->>Controller: Apartment
    Controller-->>Client: 200 OK (JSON Apartment)

    %% POST REQUEST FLOW
    Client->>Controller: POST /create (JSON Apartment)
    Controller->>Service: save(apartment)
    Service->>Repository: save(apartment)
    Repository->>DB: INSERT INTO apartment (...)
    DB-->>Repository: Apartment guardado
    Repository-->>Service: Apartment
    Service-->>Controller: Apartment
    Controller-->>Client: 201 Created (JSON Apartment)
```    

---

## 1. Modelo de Datos (Capa Entity)
La clase `Apartment` es el modelo de nuestros datos. Define la estructura que se almacenará en la base de datos y que se devolverá como respuesta JSON.

### `Apartment.java`
```java
@Entity // Indica a JPA/Hibernate que esta clase se mapea a una tabla de la base de datos.
public class Apartment {

    @Id // Define la clave primaria de la base de datos.
    protected String id;

    // ... otros campos como precio, área, habitaciones ...

    // Constructor por defecto
    public Apartment() {
        // ANÁLISIS DE LA LÍNEA:
        // Cada vez que se crea un nuevo objeto, se genera un ID único.
        // Este es el punto de inicio del ciclo de "Create".
        this.id = UUID.randomUUID().toString(); 
    }
}
```

---

## 2. Ciclo GET: Buscar Apartamento por ID
Este ciclo se centra en recuperar datos existentes utilizando un parámetro específico.

### A. Capa Controller (Punto de Entrada)
```java
@GetMapping("/getById") // Define el endpoint HTTP GET.
public Apartment getApartmentById(@RequestParam String id){
    // ENTRADA: '@RequestParam String id' captura el ID desde la URL (ej: ?id=123).
    // ACCIÓN: Llama a la capa de servicio pasando el ID.
    // SALIDA: El objeto Apartment devuelto se envía a Postman como JSON.
    return apartmentService.findApartmentById(id);
}
```

### B. Capa Service (Lógica de Negocio)
```java
public Apartment findApartmentById(String id) {
    // ENTRADA: Recibe el String 'id' desde el controller.
    // ACCIÓN: Consulta el repositorio. '.orElse(null)' gestiona el caso "no encontrado".
    // SALIDA: Devuelve el objeto Apartment encontrado o null.
    return apartmentRepository.findById(id).orElse(null);
}
```

### C. Capa Repository (Acceso a Datos)
```java
public interface ApartmentRepository extends CrudRepository<Apartment, String> {
    // ACCIÓN: Extiende CrudRepository para heredar la lógica de
    // "SELECT * FROM apartment WHERE id = ?".
}
```

---

## 3. Ciclo POST: Crear Nuevo Apartamento
Este ciclo implica enviar nuevos datos para que se persistan en la base de datos.

**Desglose Paso a Paso:**
1. **Request:** El usuario envía un cuerpo JSON mediante Postman al endpoint `/create`.
2. **Controller:** Captura el JSON y lo convierte en un objeto `Apartment`.
3. **Service:** Recibe el objeto y ejecuta el método `save()`.
4. **Repository:** Ejecuta una sentencia SQL `INSERT`.

---

## 4. Tabla Resumen: Entradas vs Salidas

| Capa        | Método   | Entrada                         | Salida                          |
|-------------|----------|----------------------------------|---------------------------------|
| Controller  | getById  | String id (Parámetro URL)        | Objeto Apartment (JSON)         |
| Service     | findAll  | Ninguna                          | Iterable<Apartment>             |
| Service     | findById | String id                        | Objeto Apartment                |
| Repository  | save     | Entidad Apartment                | Apartment (Guardado en la BD)   |

---

## 5. Demostración en Postman

### Ejemplo de Request GET
**Método:** GET  
**URL:**
```
http://localhost:8080/getById?id=tu-uuid-aquí
```

**Response (200 OK):**
```json
{
    "id": "86da7c7b-3b0d-4f36-a36c-974a6f233f20",
    "price": 450000,
    "area": 120,
    "bedrooms": 3,
    "reviews": []
}
```

### Ejemplo de Request POST
**Método:** POST  

**Body (JSON):**
```json
{
    "price": 320000,
    "area": 95,
    "bedrooms": 2,
    "bathrooms": 1
}
```

**Respuesta:**  
El servidor devuelve el objeto creado incluyendo el `id` generado automáticamente.