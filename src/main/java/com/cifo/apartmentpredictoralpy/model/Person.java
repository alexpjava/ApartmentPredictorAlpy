package com.cifo.apartmentpredictoralpy.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;

/**
 * @MappedSuperclass indicates that this class provides persistent fields
 * which will be inherited by its subclasses (e.g., Owner and Reviewer),
 * but this class itself is not mapped to a database table.
 *
 * The fields defined here (id, name, email, age) will be included in the
 * tables of the subclasses, avoiding code duplication while ensuring
 * consistent structure across all entities that extend Person.
 */
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerson;
    private String name;
    private String email;
    private int age;

    public Person() {}

    public Person(long idPerson, String name, String email, int age) {
        this.idPerson = idPerson;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public long getIdPerson() {
        return idPerson;
    }
    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
