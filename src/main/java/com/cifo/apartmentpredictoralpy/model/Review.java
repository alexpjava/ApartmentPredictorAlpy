package com.cifo.apartmentpredictoralpy.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
//@Table(name = "Review")

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String comment;
    private LocalDate date;
    private String title;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "idReviewer")
    private Reviewer reviewer;  // one reviewer
    @ManyToOne
    @JoinColumn(name = "idApartment")
    private Apartment apartment; // one apartment


    public Review() {}

    public Review(Long id, int rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() { return rating; }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Reviewer getReviewer() {
        return reviewer;
    }
    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Apartment getApartment() {
        return apartment;
    }
    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", reviewer=" + reviewer +
                ", apartment=" + apartment +
                '}';
    }
}
