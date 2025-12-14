package com.cifo.apartmentpredictoralpy.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

/**
 * Represents the Apartment entity within the application's data model.
 *
 * This class defines the structure of the corresponding database table,
 * including its main attributes and any relationships with other domain
 * entities. It is used by JPA/Hibernate to automatically map its fields
 * to persistent storage.
 */

@Entity
//@Component
//@Table(name = "Apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idApartment;

    private Integer price;
    private Integer area;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer stories;
    private boolean mainroad;
    private boolean guestroom;
    private boolean basement;
    private boolean hotwater;
    private boolean heating;
    private boolean airconditioning;
    private int parking;
    private boolean prefarea;
    private String furnishingstatus;

    //Relationships
    /**
     * Esta propiedad define una relación muchos a uno (N..1) entre Apartment y Owner,
     * donde múltiples Apartments pueden estar asociados a un mismo Owner.
     *
     * La anotación @ManyToOne indica que Apartment es el lado propietario de la relación
     * y es responsable de mantener la clave foránea en la base de datos.
     *
     * La anotación @JoinColumn(name = "idOwner") especifica la columna de la tabla
     * Apartment que actúa como clave foránea y referencia al identificador del Owner.
     *
     * Esta columna (idOwner) guarda el ID del Owner al que pertenece el Apartment y
     * debe coincidir con la clave primaria de la tabla Owner (Owner.idOwner), garantizando
     * la integridad referencial en la base de datos.
     *
     * Por ejemplo, en la base de datos:
     *   - Owner.idOwner → clave primaria de Owner
     *   - Apartment.idOwner → clave foránea que apunta a Owner.idOwner
     *
     * Esto asegura que cada Apartment está asociado a un Owner válido existente.
     *
     * El atributo owner representa la referencia al Owner asociado al Apartment,
     * permitiendo navegar desde un Apartment hacia su Owner.
     */
    @ManyToOne
    @JoinColumn(name = "idPerson")
    private Owner owner;

    @OneToMany(
            mappedBy = "apartment",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();

    public Apartment() {
    }

    public Apartment(long idApartment, Integer price, Integer area, Integer bedrooms, Integer bathrooms, Integer stories, boolean mainroad, boolean guestroom, boolean basement, boolean hotwater, boolean heating, boolean airconditioning, int parking, boolean prefarea, String furnishingstatus, Owner owner, List<Review> reviews) {
        this.idApartment = idApartment;
        this.price = price;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.stories = stories;
        this.mainroad = mainroad;
        this.guestroom = guestroom;
        this.basement = basement;
        this.hotwater = hotwater;
        this.heating = heating;
        this.airconditioning = airconditioning;
        this.parking = parking;
        this.prefarea = prefarea;
        this.furnishingstatus = furnishingstatus;
        this.owner = owner;
        this.reviews = reviews;
    }

    public long getIdApartment() {
        return idApartment;
    }


    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getStories() {
        return stories;
    }

    public void setStories(Integer stories) {
        this.stories = stories;
    }

    public boolean isMainroad() {
        return mainroad;
    }

    public void setMainroad(boolean mainroad) {
        this.mainroad = mainroad;
    }

    public boolean isGuestroom() {
        return guestroom;
    }

    public void setGuestroom(boolean guestroom) {
        this.guestroom = guestroom;
    }

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public boolean isHotwater() {
        return hotwater;
    }

    public void setHotwater(boolean hotwater) {
        this.hotwater = hotwater;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public boolean isAirconditioning() {
        return airconditioning;
    }

    public void setAirconditioning(boolean airconditioning) {
        this.airconditioning = airconditioning;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public boolean isPrefarea() {
        return prefarea;
    }

    public void setPrefarea(boolean prefarea) {
        this.prefarea = prefarea;
    }

    public String getFurnishingstatus() {
        return furnishingstatus;
    }

    public void setFurnishingstatus(String furnishingstatus) {
        this.furnishingstatus = furnishingstatus;
    }

    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Review> getReviews() {
        return reviews;
    }
    public void addReview(Review review) {
        this.reviews.add(review);
        review.setApartment(this); // Keep relation consistent. IA advice after checking.
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "idApartment=" + idApartment +
                ", price=" + price +
                ", area=" + area +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", stories=" + stories +
                ", mainroad=" + mainroad +
                ", guestroom=" + guestroom +
                ", basement=" + basement +
                ", hotwater=" + hotwater +
                ", heating=" + heating +
                ", airconditioning=" + airconditioning +
                ", parking=" + parking +
                ", prefarea=" + prefarea +
                ", furnishingstatus='" + furnishingstatus + '\'' +
                ", owner=" + owner +
                ", reviews=" + reviews +
                '}';
    }

}
