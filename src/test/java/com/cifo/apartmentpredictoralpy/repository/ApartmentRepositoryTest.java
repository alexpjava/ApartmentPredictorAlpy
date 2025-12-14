package com.cifo.apartmentpredictoralpy.repository;

import static org.assertj.core.api.Assertions.assertThat;


import com.cifo.apartmentpredictoralpy.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.cifo.apartmentpredictoralpy.model.Apartment;
import com.cifo.apartmentpredictoralpy.model.Owner;

/**
 * NOTE: Difference between @SpringBootTest and @DataJpaTest
 *
 * @SpringBootTest:
 * - Loads the entire Spring application context (controllers, services, repositories, configurations, etc.).
 * - Used for full integration tests that require the whole application running.
 * - Slower, but allows testing complete workflows end-to-end.
 *
 * @DataJpaTest:
 * - Loads only JPA-related components (entities, repositories, DataSource).
 * - Uses an in-memory H2 database by default.
 * - Each test runs in a transaction that is rolled back after the test finishes.
 * - Much faster and used specifically for testing the persistence layer (repositories).
 *
 * In summary:
 * Use @SpringBootTest when testing the full system.
 * Use @DataJpaTest when testing only the JPA repository layer.
 */

//@DataJpaTest 
@SpringBootTest
public class ApartmentRepositoryTest {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    void testCreateAndPersistApartment() {

        //Create an Owner (if your entity requires it)
        Owner owner = new Owner();
        owner.setName("John Doe");

        // Create Apartment
        Apartment apartment = new Apartment();
        apartment.setPrice(150000);
        apartment.setArea(85);
        apartment.setBedrooms(3);
        apartment.setBathrooms(2);
        apartment.setStories(1);
        apartment.setMainroad(true);
        apartment.setGuestroom(false);
        apartment.setBasement(false);
        apartment.setHotwater(true);
        apartment.setHeating(true);
        apartment.setAirconditioning(true);
        apartment.setParking(1);
        apartment.setPrefarea(true);
        apartment.setFurnishingstatus("furnished");
        apartment.setOwner(owner);

        // Persist object into H2
        Apartment saved = apartmentRepository.save(apartment);

        // Assertions
        assertThat(saved).isNotNull();
        assertThat(saved.getIdApartment()).isGreaterThan(0);
        assertThat(saved.getPrice()).isEqualTo(150000);
    }


}
