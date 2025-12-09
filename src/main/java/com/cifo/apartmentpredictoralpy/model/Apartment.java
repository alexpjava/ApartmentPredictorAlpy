package com.cifo.apartmentpredictoralpy.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

/**
 * Represents the Apartment entity within the application's data model.
 *
 * This class defines the structure of the corresponding database table,
 * including its main attributes and any relationships with other domain
 * entities. It is used by JPA/Hibernate to automatically map its fields
 * to persistent storage.
 */

@Entity
@Table(name = "Apartment")

public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    // Relationships
    //private Owner owner;
    //private List<Review> reviews = new ArrayList<>();

    public Apartment() {
    }

    public Apartment(long id, Integer price, Integer area, Integer bedrooms, Integer bathrooms, Integer stories, boolean mainroad, boolean guestroom, boolean basement, boolean hotwater, boolean heating, boolean airconditioning, int parking, boolean prefarea, String furnishingstatus, Owner owner, List<Review> reviews) {
        this.id = id;
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
        //this.owner = owner;
        //this.reviews = reviews;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setParking(byte parking) {
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
/* 
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
                "id=" + id +
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
                */
}
