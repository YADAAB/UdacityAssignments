package com.udacity.course2.dogrest.service;

import com.udacity.course2.dogrest.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DogQueryService {


public List<Dog> getDogBreed();
public Optional<Dog> getDogBreedById(Long id); //returns dog breed by the id of Dog
public List<String> getDogNames();
public String deleteDogById(Long id);

}

/*
retrieveDogBreed
retrieveDogBreedById
retrieveDogNames

a list of Dog breeds
a list of Dog breeds by Id
a list of Dog names

* */