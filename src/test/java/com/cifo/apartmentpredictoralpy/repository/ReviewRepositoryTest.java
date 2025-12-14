package com.cifo.apartmentpredictoralpy.repository;

import com.cifo.apartmentpredictoralpy.model.Apartment;
import com.cifo.apartmentpredictoralpy.model.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;
    //@Autowired
    //private Apartment apartment;

    @Test
    void testCreateAndPersistReview() {

        Review review1 = new Review();

        review1.setComment("This apartment exceeded my expectations. The location is perfect and the amenities are top-notch. Highly recommended for anyone looking for a comfortable stay.");
        review1.setRating(5);
        review1.setDate(LocalDate.now());
        review1.setTitle("Nice Apartment in Fifth Avenue");
        //review1.setApartment(apartment);

    }

}
