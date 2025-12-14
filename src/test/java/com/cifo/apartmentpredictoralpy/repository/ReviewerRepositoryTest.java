package com.cifo.apartmentpredictoralpy.repository;

import com.cifo.apartmentpredictoralpy.model.Review;
import com.cifo.apartmentpredictoralpy.model.Reviewer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReviewerRepositoryTest {

    @Autowired
    private ReviewerRepository reviewerRepository;

    @Test
    void testCreateAndPersistReviewer() {

        //Create an Owner (if your entity requires it)


        Reviewer reviewer = new Reviewer();
        reviewer.setName("Ana Torres");
        reviewer.setEmail("ana.torres@email.com");
        reviewer.setAge(28);


        // Crear reviews
        Review review1 = new Review();
        Review review2 = new Review();

        // Asociar reviews al reviewer
        reviewer.addReview(review1);
        reviewer.addReview(review2);


        // Persist object into H2
        Reviewer saved = reviewerRepository.save(reviewer);

        // Assertions
        assertThat(saved).isNotNull();
        assertThat(saved.getIdPerson()).isGreaterThan(0);
        assertThat(saved.getAge()).isEqualTo(28);
    }


}
