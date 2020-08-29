package com.udacity.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DogQuery implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public DogQuery(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    //public Iterable<Location> findAllLocations() { return locationRepository.findAll(); }

    public Iterable<Dog> findAllDogs()
    {
        return dogRepository.findAll();
    }

    public Iterable<String> findDogBreedById(Long id)
    {
        Optional<Dog> opDog =  dogRepository.findById(id);
        if (opDog.isPresent())
        {
            return Arrays.asList(opDog.get().getBreed());
        }
        else
        {
            System.out.println("No Id ");
            //throw new BreedNotFoundException("Breed Not Found", id);

        }
        return Arrays.asList("hello");
    }

    public List<String> findAllDogNames()
    {
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        List <String> dog_names = new ArrayList<String>();
        for(Dog d : dogs){
            dog_names.add(d.getName());
        }
        return dog_names;
    }
}
