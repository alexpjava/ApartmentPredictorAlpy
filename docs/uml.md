# UML Diagram

## UML Diagram

### Diagram

```mermaid

classDiagram
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

    Person <|-- Owner
    Person <|-- Reviewer

    Owner "1" --> "0..*" Apartment : owns
    Apartment "1" --> "0..*" Review : has
    Reviewer "1" --> "0..*" Review : writes
    Review "1" --> "1" Reviewer : reviewer
    Review "1" --> "1" Apartment : apartment
```
