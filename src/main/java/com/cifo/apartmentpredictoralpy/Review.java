package com.cifo.apartmentpredictoralpy;

import java.time.LocalDate;

public class Review {

    private Long id;
    private int rating;
    private String comment;
    private LocalDate date;

    // Relationships
    private Reviewer reviewer;  // one reviewer
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
