package com.udacity.course2.dogrest.repository;

import com.udacity.course2.dogrest.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}

