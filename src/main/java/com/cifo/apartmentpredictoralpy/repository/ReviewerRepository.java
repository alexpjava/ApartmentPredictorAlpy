package com.cifo.apartmentpredictoralpy.repository;

import com.cifo.apartmentpredictoralpy.model.Apartment;
import com.cifo.apartmentpredictoralpy.model.Reviewer;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for managing Reviewer entities.
 *
 * This interface extends CrudRepository, which provides basic CRUD
 * (Create, Read, Update, Delete) operations without requiring any
 * manual implementation. The first generic parameter specifies the
 * entity type (Reviewer), and the second one defines the type of
 * the entity's primary key (String in this case).
 *
 * Spring automatically generates the implementation at runtime,
 * allowing the application to interact with the database in a clean
 * and declarative way.
 */

/**
 This line declares a public Java interface called ReviewerRepository.
 An interface defines a contract (methods) but does not contain implementations.
 The keyword 'extends' means that ReviewerRepository inherits from another interface.
 In Java, interfaces extend other interfaces (they do not use 'implements').
 CrudRepository<Reviewer, Long> is a Spring Data interface that already defines
 basic CRUD operations (Create, Read, Update, Delete).
 - Reviewer: the entity type this repository manages.
 - Long: the type of the entity's primary key (@Id).
 By extending CrudRepository, Spring Data automatically provides the
 implementation of these methods at runtime, so no manual coding is required.
 */

public interface ReviewerRepository extends CrudRepository<Reviewer, Long> {

}
