package com.cifo.apartmentpredictoralpy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The Owner entity represents a property owner in the system.
 * It extends the Person base class, inheriting personal information fields.
 *
 * This entity is mapped to the "owners" table and maintains a one-to-many
 * relationship with Apartment. Each owner may manage multiple apartments.
 *
 * JPA Requirements:
 * - A no-argument constructor is required by the JPA specification.
 * - The primary key (id) is inherited from Person, annotated in the superclass.
 * - The apartments list is configured as a bidirectional relationship using
 *   @OneToMany(mappedBy = "owner").
 */

@Entity
@Table(name = "owner")

public class Owner extends Person {

    private boolean isActive;
    private boolean isBusiness;
    private String idLegalOwner;
    private LocalDate registrationDate;
    private int qtyDaysAsOwner;

    // Relationships
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apartment> apartments = new ArrayList<>();

    public Owner() {   // OBLIGATORIO para JPA
        super();
    }

    public Owner(int id, String name, String email, int age) {
        super(id, name, email, age);
    }


    public Owner(int id, String name, String email, int age, boolean isActive, boolean isBusiness, String idLegalOwner, LocalDate registrationDate, int qtyDaysAsOwner, List<Apartment> apartments) {
        super(id, name, email, age);
        this.isActive = isActive;
        this.isBusiness = isBusiness;
        this.idLegalOwner = idLegalOwner;
        this.registrationDate = registrationDate;
        this.qtyDaysAsOwner = qtyDaysAsOwner;
        this.apartments = apartments;
    }

    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsBusiness() {
        return isBusiness;
    }
    public void setIsBusiness(boolean business) {
        this.isBusiness = business;
    }

    public String getIdLegalOwner() {
        return idLegalOwner;
    }
    public void setIdLegalOwner(String idLegalOwner) {
        this.idLegalOwner = idLegalOwner;
    }

    public LocalDate getRegistrationDate()
    { return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
    }

    public int getQtyDaysAsOwner() {
        return qtyDaysAsOwner;
    }

    public void setQtyDaysAsOwner(int qtyDaysAsOwner) {
        this.qtyDaysAsOwner = qtyDaysAsOwner;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }
    //public void addApartment(Apartment a) {
    //    this.apartments.add(a);
     //   a.setOwner(this); // Keep relation consistent. IA advice after checking.
   // }

    @Override
    public String toString() {
        return "Owner{" +
                "isActive=" + isActive +
                ", isBusiness=" + isBusiness +
                ", idLegalOwner='" + idLegalOwner + '\'' +
                ", registrationDate=" + registrationDate +
                ", qtyDaysAsOwner=" + qtyDaysAsOwner +
                ", apartments=" + apartments +
                '}';
    }
}
