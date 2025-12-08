# Project Lombok (Java) - Resumen

## ¿Qué es Project Lombok?

Lombok es una librería para Java que reduce el código repetitivo
(boilerplate) mediante anotaciones que generan automáticamente getters,
setters, constructores, métodos `toString`, `equals`, `hashCode`,
patrones builder, logs y más.

## ¿Qué problemas resuelve?

Java tiende a requerir mucho código repetitivo. Lombok elimina: -
Getters y setters - Constructores - Builder pattern - Métodos `equals()`
/ `hashCode()` - `toString()` - Configuración de logs

Esto hace las clases más limpias y legibles.

## Anotaciones principales

### @Getter / @Setter

Genera getters y setters automáticamente:

``` java
@Getter @Setter
public class Usuario {
    private String nombre;
    private int edad;
}
```

### @Data

Incluye `@Getter`, `@Setter`, `@RequiredArgsConstructor`, `@ToString`,
`@EqualsAndHashCode`:

``` java
@Data
public class Usuario {
    private String nombre;
    private int edad;
}
```

### @NoArgsConstructor / @AllArgsConstructor / @RequiredArgsConstructor

Genera diferentes tipos de constructores.

### @Builder

Crea un patrón Builder:

``` java
@Builder
public class Usuario {
    private String nombre;
    private int edad;
}
```

### @Slf4j

Crea un logger listo para usar:

``` java
@Slf4j
public class Servicio {
    public void ejecutar() {
        log.info("Ejecutando...");
    }
}
```

## Instalación

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

## Consideraciones

-   Puede ocultar parte del código, dificultando su comprensión a
    principiantes.
-   En entidades JPA es recomendable evitar `@Data`.
-   Requiere soporte del IDE para funcionar correctamente.
