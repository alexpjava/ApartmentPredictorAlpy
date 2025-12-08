# Project Lombok (Java) - Summary

## What is Project Lombok?

Lombok is a Java library that reduces boilerplate code by using
annotations that automatically generate getters, setters, constructors,
`toString`, `equals`, `hashCode`, builder patterns, loggers, and more.

## What problems does it solve?

Java often requires a lot of repetitive code. Lombok removes: - Getters
and setters - Constructors - Builder pattern - `equals()` / `hashCode()`
methods - `toString()` - Logger setup

This makes classes cleaner and easier to read.

## Main Annotations

### @Getter / @Setter

Automatically generates getter and setter methods:

``` java
@Getter @Setter
public class User {
    private String name;
    private int age;
}
```

### @Data

Includes `@Getter`, `@Setter`, `@RequiredArgsConstructor`, `@ToString`,
and `@EqualsAndHashCode`:

``` java
@Data
public class User {
    private String name;
    private int age;
}
```

### @NoArgsConstructor / @AllArgsConstructor / @RequiredArgsConstructor

Generates different types of constructors.

### @Builder

Creates a Builder pattern:

``` java
@Builder
public class User {
    private String name;
    private int age;
}
```

### @Slf4j

Creates a ready-to-use logger:

``` java
@Slf4j
public class Service {
    public void run() {
        log.info("Running...");
    }
}
```

## Installation

### Maven

``` xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>
```

### Gradle

``` gradle
compileOnly 'org.projectlombok:lombok:1.18.32'
annotationProcessor 'org.projectlombok:lombok:1.18.32'
```

## Considerations

-   It can hide generated code, which may confuse beginners.
-   Avoid using `@Data` on JPA entities.
-   Requires IDE support to work correctly.
