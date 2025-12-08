# Spring Boot – IoC & DI Flow Diagram

```mermaid
flowchart TD

    A(["1. Spring Boot Application Starts"]) --> B["2. Component Scanning (@ComponentScan)"]
    B --> C["3. IoC Container Creates Beans (ApplicationContext)"]
    C --> D["4. Dependency Resolution (Constructor Analysis)"]
    D --> E["5. Dependency Injection (Beans Wired Together)"]

    %% Beans
    C --> F[[OrderController Bean]]
    C --> G[[OrderService Bean]]
    C --> H[[OrderRepository Bean]]

    %% DI Arrows
    F -->|needs OrderService| G
    G -->|needs OrderRepository| H
```

## Explanation

### 1. Spring Boot Application Starts
Spring Boot initializes the IoC container.

### 2. Component Scanning
Spring detects classes annotated with `@Controller`, `@Service`, `@Repository`, and `@Component`.

### 3. IoC Container Creates Beans
Spring instantiates and manages these components as beans.

### 4. Dependency Resolution
Spring reads constructor parameters to determine dependencies.

### 5. Dependency Injection
Spring injects the required beans into each component automatically.
