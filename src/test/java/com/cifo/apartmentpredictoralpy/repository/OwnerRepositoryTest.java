package com.cifo.apartmentpredictoralpy.repository;

import com.cifo.apartmentpredictoralpy.model.Apartment;
import com.cifo.apartmentpredictoralpy.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void testCreateAndPersistOwner() {

        //Create an Owner (if your entity requires it)
        Owner owner = new Owner();
        owner.setName("John Doe");
        owner.setEmail("John.Doe@gmail.com");
        owner.setAge(35);
        owner.setIsActive(true);
        owner.setIsBusiness(true);
        owner.setIdLegalOwner("DNI-87654321B");
        owner.setRegistrationDate(LocalDate.now());
        owner.addApartment(new Apartment());


        // Persist object into H2
        Owner saved = ownerRepository.save(owner);

        // Assertions
        assertThat(saved).isNotNull();
        assertThat(saved.getIdPerson()).isGreaterThan(0);
        assertThat(saved.getAge()).isEqualTo(35);
    }
}
