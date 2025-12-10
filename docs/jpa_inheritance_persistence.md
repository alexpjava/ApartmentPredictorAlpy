# JPA Inheritance and Persistence: Person → Owner

This document explains how to persist entities when using inheritance in JPA/Hibernate, specifically for the model:

- `Person` (abstract base class)
- `Owner` (inherits from `Person`)
- `Reviewer` (inherits from `Person`)

---

## 1. Current Structure

You currently have:

```java
@MappedSuperclass
public abstract class Person { ... }
```

```java
@Entity
public class Owner extends Person { ... }
```

### What this means

- `Person` **is not an entity** and **does not have a table** in the database.
- All fields defined in `Person` (id, name, email, age) are **inherited by the child class**, but **the table belongs only to the child**.
- Only classes annotated with `@Entity` (e.g., `Owner`) are persisted.

This is the correct approach if `Person` should *never* be stored by itself.

---

## 2. How Persistence Works With @MappedSuperclass

When you persist an `Owner`:

```java
Owner o = new Owner();
o.setName("John");
o.setEmail("john@example.com");
o.setAge(35);
o.setIsActive(true);

ownerRepository.save(o);
```

Hibernate inserts a row into the `owner` table that includes:

- Columns inherited from `Person`
- Columns defined in `Owner`

### Example table structure

| id | name |      email       | age | is_active | is_business | ... |
|----|------|------------------|-----|-----------|-------------|-----|
| 1  | John | john@example.com | 35  |    true   |    false    | ... |

`Person` does not create a table.

---

## 3. If You Want `Person` to Have Its Own Table

Then you should **not** use `@MappedSuperclass`.  
Instead, JPA provides several inheritance strategies.

### Option 1 — SINGLE TABLE (one table for all)

```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Person { ... }
```

```java
@Entity
@DiscriminatorValue("OWNER")
public class Owner extends Person { ... }
```

**Pros**
- Fast  
- Simple schema  

**Cons**
- Table grows wide with unused columns

---

### Option 2 — JOINED (normalized structure)

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person { ... }
```

```java
@Entity
public class Owner extends Person { ... }
```

**Pros**
- Clean database structure  
- Good normalization  

**Cons**
- Requires JOINs → slightly slower

---

### Option 3 — TABLE_PER_CLASS  
(Not recommended)

Each subclass gets its own independent table.

---

## 4. Best Choice for Your Project

Given your structure:

- `Person` should NOT be persisted alone  
- `Owner` and `Reviewer` are the entities that matter  

➡️ **`@MappedSuperclass` is the correct strategy.**

It avoids redundant tables and provides clean inheritance.

---

## 5. Summary

### ✔ @MappedSuperclass behavior
- No table for the superclass.
- Subclasses inherit its fields.
- Only subclasses annotated with `@Entity` are persisted.

### ✔ Persisting Owner
```java
Owner owner = new Owner();
ownerRepository.save(owner);
```

### ✔ Hibernate stores Person + Owner fields together in the Owner table.

---
