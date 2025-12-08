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