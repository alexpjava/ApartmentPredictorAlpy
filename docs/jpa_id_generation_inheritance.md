# ID Generation in Inherited Entities (Owner & Reviewer)

This document explains how primary keys (`id`) are generated in the database when using inheritance with JPA and the `@MappedSuperclass` strategy, as well as alternative strategies if global IDs are required.

---

## 1. Current Configuration

```java
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
```

```java
@Entity
public class Owner extends Person { ... }

@Entity
public class Reviewer extends Person { ... }
```

---

## 2. How IDs Are Generated with @MappedSuperclass

When using `@MappedSuperclass`:

- The superclass (`Person`) **does not have its own table**
- Each subclass (`Owner`, `Reviewer`) **has its own table**
- Each table generates its IDs **independently**
- `GenerationType.IDENTITY` delegates ID generation to the database (auto-increment)

### Result

- `owner.id` values are unique **within the owner table**
- `reviewer.id` values are unique **within the reviewer table**
- IDs **may be duplicated across tables**

This behavior is expected and correct.

---

## 3. Example Database State

### Owner Table

| id | name  | email |
|----|-------|-------|
| 1  | Alex  | a@a.com |
| 2  | Maria | m@m.com |

### Reviewer Table

| id | name  | email |
|----|-------|-------|
| 1  | John  | j@j.com |
| 2  | Laura | l@l.com |

Even though both tables contain `id = 1`, there is no conflict because the IDs belong to different tables.

---

## 4. Why This Happens

This occurs because:

- `Person` is not an entity and does not define a table
- Each concrete entity manages its own auto-increment sequence
- The database enforces uniqueness only at the table level

---

## 5. Is This a Problem?

### This is NOT a problem if:
- `Owner` and `Reviewer` are conceptually different entities
- IDs are never compared across tables
- Relationships always reference a specific entity type

### This MAY be a problem if:
- You need a single global identifier for all people
- Other tables must reference `Person` generically
- You need polymorphic queries at the database level

---

## 6. How to Get Global Unique IDs

To have globally unique IDs across all subclasses, you must change the inheritance strategy.

### Option 1 — JOINED Strategy (Recommended)

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
```

Resulting structure:

- A `person` table with unique IDs
- `owner` and `reviewer` tables reference `person.id` as a foreign key

#### Example

**Person Table**

| id | name |
|----|------|
| 1  | Alex |
| 2  | John |

**Owner Table**

| id | is_active |
|----|-----------|
| 1  | true |

**Reviewer Table**

| id | rating |
|----|--------|
| 2  | 5 |

IDs are now globally unique.

---

### Option 2 — SINGLE_TABLE Strategy

All subclasses are stored in a single table with a discriminator column.

- One table
- Global unique IDs
- Faster queries
- May contain many unused columns

---

## 7. Summary

| Strategy | Global Unique IDs | Tables |
|--------|------------------|--------|
| `@MappedSuperclass` | ❌ No | owner, reviewer |
| `JOINED` | ✅ Yes | person + owner + reviewer |
| `SINGLE_TABLE` | ✅ Yes | person |

---

## 8. Recommendation

For your current model, where:

- `Person` should not be persisted directly
- `Owner` and `Reviewer` are independent entities

➡️ **`@MappedSuperclass` with independent ID generation is the correct choice.**

Change the inheritance strategy only if global IDs or polymorphic persistence are required.
