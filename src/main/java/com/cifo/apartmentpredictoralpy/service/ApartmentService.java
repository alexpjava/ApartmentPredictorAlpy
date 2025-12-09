package com.cifo.apartmentpredictoralpy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cifo.apartmentpredictoralpy.model.Apartment;

/**
 * Service class responsible for handling business logic related to Apartment entities.
 *
 * This class defines high-level operations such as listing all apartments and 
 * creating, reading, updating, or deleting apartment records (CRUD). Although the methods 
 * are currently placeholders with no implementation, they represent the typical 
 * structure of a service layer in a Spring application.
 *
 * The @Service annotation indicates that this class is a Spring-managed component 
 * and can be injected into controllers or other services where apartment-related 
 * operations are required.
 */

@Service
public class ApartmentService {

    public List<Apartment> findAllApartments(){

        return null;
    }

    public void createApartment(){

    }
    public void readApartment(){

    }
    public void updateApartment(){

    }
    public void deleteApartment(){

    }

}
