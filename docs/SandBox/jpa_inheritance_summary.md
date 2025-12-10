# JPA Inheritance and Persistence Summary

This document explains how inheritance and persistence work in the project for the `Person`, `Owner`, and `Reviewer` classes.

---

## JPA Inheritance Overview

Your model uses the following structure:

- **Person** → Base class  
- **Owner** and **Reviewer** → Subclasses that inherit from Person

`Person` is annotated with:

```java
@MappedSuperclass
```

This means:

- `Person` is **not** an entity and **does not have its own database table**.
- All fields in `Person` (`id`, `name`, `email`, `age`) are **inherited and mapped** into the tables of its subclasses.
- Only subclasses such as `Owner` or `Reviewer` are persisted.

---

## Why @MappedSuperclass?

Because `Person` is conceptual and should not be stored directly.

### Advantages:
- Avoids duplicated fields across entities.
- Keeps inheritance clean.
- The database remains simple with only necessary tables.

---

## How Persistence Works

Since `Person` is not an entity:
- You **cannot** persist a `Person`.
- You **do** persist `Owner` or `Reviewer`.

### Example:

```java
Owner owner = new Owner();
owner.setName("Alice");
owner.setEmail("alice@example.com");
owner.setAge(32);

ownerRepository.save(owner);
```

Hibernate inserts all fields from:
- **Person** (id, name, email, age)
- **Owner** (isActive, isBusiness, etc.)

into **one single table**: `owner`.

---

## Table Structure with @MappedSuperclass

The table for `Owner` contains:

| Column | Source Class |
|--------|--------------|
| id | Person |
| name | Person |
| email | Person |
| age | Person |
| is_active | Owner |
| is_business | Owner |
| ... | Owner |

---

## If You Wanted Person to Have Its Own Table

You would need an inheritance strategy:

### **Option 1 — SINGLE_TABLE**
One table for all classes.

### **Option 2 — JOINED**
Separate tables, linked with foreign keys.

### **Option 3 — TABLE_PER_CLASS**
One table per class (not usually recommended).

---

## Recommended Strategy for This Project

✔ `@MappedSuperclass` is the correct choice.  
✔ Person remains abstract and not persisted.  
✔ Owner and Reviewer have clean tables.  

---

## Summary

- `Person` defines reusable fields but is **not** saved to the database**.
- `Owner` and `Reviewer` inherit fields and **are persisted normally**.
- SQL tables only exist for actual entities.
- The architecture avoids duplication and simplifies the model.

