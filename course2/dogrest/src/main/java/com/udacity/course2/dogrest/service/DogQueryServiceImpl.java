package com.udacity.course2.dogrest.service;

import com.udacity.course2.dogrest.entity.Dog;
import com.udacity.course2.dogrest.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogQueryServiceImpl implements DogQueryService{
    @Autowired
    DogRepository dogRepository;
    private List<Dog> list_of_dogs;
    private List<String> dog_names = new ArrayList<String>();
    private Dog byId;

    @Override
    public List<Dog> getDogBreed() {
        return (List<Dog>) dogRepository.findAll();
    }


    @Override
    public Optional<Dog> getDogBreedById(Long id) {
//        byId = (Dog) dogRepository.findById(id);
        return dogRepository.findById(id);
    }

    @Override
    public List<String> getDogNames() {
        list_of_dogs = (List<Dog>) dogRepository.findAll();
        for (int i=0; i < list_of_dogs.size(); ++i)
        {
            dog_names.add(list_of_dogs.get(i).getName());
        }
        System.out.println("dog names "+dog_names);
        return dog_names;
    }

    @Override
    public String deleteDogById(Long id)
    {
        dogRepository.deleteById(id);
        if (dogRepository.existsById(id)) {
        return "failed";
    } else {
            return "success";
    }
    }
}
