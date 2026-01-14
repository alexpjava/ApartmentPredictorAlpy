```mermaid
classDiagram
    direction LR

    %% Jerarquía de Personas
    class Person {
        <<abstract>>
        -int id
        -String name
        -String email
        -int age
    }

    class Owner {
        -boolean isActive
        -boolean isBusiness
        -String idLegalOwner
        -LocalDate registrationDate
        -int qtyDaysAsOwner
        -List~Property~ properties
        +addProperty(Property)
    }

    class Reviewer {
        -List~Review~ reviews
        +addReview(Review)
    }

    %% Jerarquía de Propiedades
    class Property {
        <<abstract>>
        -int id
        +double area
        +int locationRating
        +String address
        -boolean mainroad
        -boolean hotwater
        -boolean heating
        -boolean airconditioning
        -byte parking
        -boolean prefarea
        -String furnishingstatus
        -Owner owner
        -List~Review~ reviews
        +abstract double calculatePrice()
        +addReview(Review)
    }

    class ResidentialProperty {
        <<abstract>>
        +int numberOfBedrooms
        +int numberOfBathrooms
        +boolean hasGarden
        +boolean guestroom
    }

    class Apartment {
        +int floorLevel
        -boolean hasBalcony
        +double calculatePrice()
    }

    class SingleFamilyHome {
        <<abstract>>
        +double lotSize
        -boolean hasGarage
        -boolean hasPool
    }

    class House {
        -boolean hasBasement
        +double calculatePrice()
    }

    class Duplex {
        -boolean hasSeparateUtilities
        +int units
        +double calculatePrice()
    }

    class Townhouse {
        -boolean hasHomeownersAssociation
        +double hoaMonthlyFee
        +double calculatePrice()
    }

    %% Sistema de Reseñas
    class Review {
        -Long id
        -int rating
        -String comment
        -LocalDate date
        -Reviewer reviewer
        -Property property
    }

    %% Relaciones de Herencia
    Person <|-- Owner
    Person <|-- Reviewer
    Property <|-- ResidentialProperty
    ResidentialProperty <|-- Apartment
    ResidentialProperty <|-- SingleFamilyHome
    SingleFamilyHome <|-- House
    SingleFamilyHome <|-- Duplex
    SingleFamilyHome <|-- Townhouse

    %% Relaciones de Asociación y Composición
    Owner "1" *-- "0..*" Property : owns
    Property "1" *--> "n" Review : has
    Reviewer "1" *--> "0..*" Review : writes
    Review "n" --o "1" Reviewer : reviewer
    Review "n" --o "1" Property : property
    ```

    