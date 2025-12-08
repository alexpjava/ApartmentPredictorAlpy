```mermaid
classDiagram
    direction LR

    %% ============================
    %% CLASES
    %% ============================

    class Person {
        <<abstract>>
        - int id
        - String name
        - String email
        - int age
    }

    class Owner {
        - boolean isActive
        - boolean isBusiness
        - String idLegalOwner
        - LocalDate registrationDate
        - int qtyDaysAsOwner
        - List~Apartment~ apartments
        + addApartment(Apartment)
    }

    class Reviewer {
        - List~Review~ reviews
        + addReview(Review)
    }

    class Apartment {
        - int id
        - Integer price
        - Integer area
        - Integer bedrooms
        - Integer bathrooms
        - Integer stories
        - boolean mainroad
        - boolean guestroom
        - boolean basement
        - boolean hotwater
        - boolean heating
        - boolean airconditioning
        - byte parking
        - boolean prefarea
        - String furnishingstatus
        - Owner owner
        - List~Review~ reviews
        + addReview(Review)
    }

    class Review {
        - Long id
        - int rating
        - String comment
        - LocalDate date
        - Reviewer reviewer
        - Apartment apartment
    }

    %% ============================
    %% HERENCIA
    %% ============================

    Person <|-- Owner
    Person <|-- Reviewer

    %% ============================
    %% RELACIONES PRINCIPALES
    %% ============================

    Owner "1" --> "0..many" Apartment : owns
    Reviewer "1" --> "0..many" Review : writes
    Apartment "1" --> "0..many" Review : has
    Review "1" --> "1" Apartment : about

    %% ============================
    %% ESTILOS (colores suaves)
    %% ============================

    classDef abstract fill:#f2f2f2,stroke:#333,stroke-width:1.5px,font-weight:bold;
    classDef entity fill:#e8f4ff,stroke:#2b6cb0,stroke-width:1.3px;
    classDef value fill:#fff5e6,stroke:#c77900,stroke-width:1.3px;

    class Person abstract
    class Owner,Reviewer entity
    class Apartment,Review value

    %% Opcional: bordes redondeados
    classDef rounded stroke-width:1px,stroke:#666,border-radius:8px;
    class Person,Owner,Reviewer,Apartment,Review rounded

```