package com.restservice.construct.RestConstruct;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface ImageRepository extends CrudRepository<Image, Long> {

}
