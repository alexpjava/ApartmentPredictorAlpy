package com.cifo.apartmentpredictoralpy.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "Reviewer")
public class Reviewer extends Person {


    // Relationships
    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public Reviewer(){
    }

    public Reviewer(long id, String name, String email, int age) {
        super(id, name, email, age);
    }

    public List<Review> getReviews() {
        return reviews;
    }
    public void addReview(Review r) {
        this.reviews.add(r);
        r.setReviewer(this); // Keep relation consistent. IA advice after checking.
    }

    @Override
    public String toString() {
        return "Reviewer{" +
                "reviews=" + reviews +
                '}';
    }
}
