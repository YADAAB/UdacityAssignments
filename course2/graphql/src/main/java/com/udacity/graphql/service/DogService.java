package com.udacity.graphql.service;

import com.udacity.graphql.entity.Dog;

import java.util.List;

public interface DogService {
    //Query
    List<Dog> findAllDogs();
    List<String> findDogBreedById(Long id);
    List<String> findAllDogNames();
    //mutations
    Dog newDog(String name, String breed, String origin);
    Boolean deleteDog(Long id);
    Dog updateDogBreed(String newBreed, Long id);
    Dog updateDogName(String newName, Long id);

}



/*
*type Query {
 findAllDogs: [Dog]!
 findDogBreedById(id: ID): [breed: String]!
 findAllDogNames: [name: String ]!
}

type Mutation {
 newDog(name: String!, breed: String!, origin: String!) : Dog!
 deleteDog(id:ID!) : Boolean
 updateDogBreed(newBreed: String!, id:ID!) : Dog!
 updateDogName(newName: String!, id:ID!) : Dog!
}


* */