package com.cifo.apartmentpredictoralpy.repository;

import org.springframework.data.repository.CrudRepository;

import com.cifo.apartmentpredictoralpy.model.Apartment;

/**
 * Repository interface for managing Apartment entities.
 *
 * This interface extends CrudRepository, which provides basic CRUD
 * (Create, Read, Update, Delete) operations without requiring any
 * manual implementation. The first generic parameter specifies the
 * entity type (Apartment), and the second one defines the type of
 * the entity's primary key (String in this case).
 *
 * Spring automatically generates the implementation at runtime,
 * allowing the application to interact with the database in a clean
 * and declarative way.
 */

public interface ApartmentRepository extends CrudRepository <Apartment, Long>{

}
