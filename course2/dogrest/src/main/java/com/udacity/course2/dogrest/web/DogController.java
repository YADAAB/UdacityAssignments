package com.udacity.course2.dogrest.web;

import com.udacity.course2.dogrest.entity.Dog;
import com.udacity.course2.dogrest.service.DogQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {
    @Autowired
    private DogQueryService dogQueryService;

    public DogController(DogQueryService dogQueryService) {
        this.dogQueryService = dogQueryService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogBreed() {
        List<Dog> list = dogQueryService.getDogBreed();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogbreedbyid")
    @ResponseBody
    public Optional<Dog> getDogBreedId(@RequestParam(value = "dogId") Long dogId ) {
        Optional<Dog> dog = dogQueryService.getDogBreedById(dogId);
        //return new ResponseEntity<List<Dog>>(dog, HttpStatus.OK);
        return dog;
    }
    /**
     @GetMapping("/{id}/breed")
     public ResponseEntity<String> getBreedByID(@PathVariable Long id) {
     String breed = dogService.retrieveDogBreedById(id);
     return new ResponseEntity<String>(breed, HttpStatus.OK);
     }

     */


    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogQueryService.getDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @PostMapping("/{id}/delete/dogs")
    public ResponseEntity<String> deleteDogById(@PathVariable Long id)
    {
        String response = dogQueryService.deleteDogById(id);
        if (response == "success")
        {
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }
        return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
    }


}
