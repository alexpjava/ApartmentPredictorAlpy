package com.cifo.apartmentpredictoralpy.model;

import java.util.ArrayList;
import java.util.List;

public class Reviewer extends Person {


    // Relationships
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
