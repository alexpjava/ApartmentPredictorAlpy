## Spring Boot vs JPA – Common Annotations

| Layer / Framework | Annotation | Package | Purpose |
|------------------|------------|---------|---------|
| Spring Framework | `@Autowired` | `org.springframework.beans.factory.annotation` | Injects a Spring-managed bean into another component. |
| Spring Framework | `@Component` | `org.springframework.stereotype` | Marks a class as a Spring component for auto-detection. |
| Spring Framework | `@Service` | `org.springframework.stereotype` | Specialization of `@Component` for the service layer. |
| Spring Framework | `@Repository` | `org.springframework.stereotype` | Specialization of `@Component` for the persistence layer. |
| Spring Framework | `@Controller` | `org.springframework.stereotype` | Marks a class as a Spring MVC controller. |
| Spring Framework | `@RestController` | `org.springframework.web.bind.annotation` | Combines `@Controller` and `@ResponseBody` for REST APIs. |
| Spring Framework | `@Qualifier` | `org.springframework.beans.factory.annotation` | Specifies which bean to inject when multiple candidates exist. |
| JPA / Hibernate | `@Entity` | `jakarta.persistence` | Marks a class as a database entity. |
| JPA / Hibernate | `@Table` | `jakarta.persistence` | Defines the database table name for the entity. |
| JPA / Hibernate | `@Id` | `jakarta.persistence` | Marks the primary key of the entity. |
| JPA / Hibernate | `@GeneratedValue` | `jakarta.persistence` | Defines how the primary key value is generated. |
| JPA / Hibernate | `@Column` | `jakarta.persistence` | Configures column details in the database table. |
| JPA / Hibernate | `@OneToMany` | `jakarta.persistence` | Defines a one-to-many relationship between entities. |
| JPA / Hibernate | `@ManyToOne` | `jakarta.persistence` | Defines a many-to-one relationship between entities. |
| JPA / Hibernate | `@OneToOne` | `jakarta.persistence` | Defines a one-to-one relationship between entities. |
| JPA / Hibernate | `@ManyToMany` | `jakarta.persistence` | Defines a many-to-many relationship between entities. |
| JPA / Hibernate | `@Transient` | `jakarta.persistence` | Marks a field that will not be persisted in the database. |


```mermaid
flowchart LR
    Spring[Spring Framework]
    JPA[JPA / Hibernate]

    Spring --> A[@Autowired<br/>Dependency Injection]
    Spring --> C[@Component]
    Spring --> S[@Service]
    Spring --> R[@Repository]
    Spring --> RC[@RestController]
    Spring --> Q[@Qualifier]

    JPA --> E[@Entity]
    JPA --> T[@Table]
    JPA --> I[@Id]
    JPA --> G[@GeneratedValue]
    JPA --> Col[@Column]
    JPA --> Rel[@OneToMany / @ManyToOne<br/>@OneToOne / @ManyToMany]
    JPA --> Tr[@Transient]
```