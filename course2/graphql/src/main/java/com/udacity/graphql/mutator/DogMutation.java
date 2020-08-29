package com.udacity.graphql.mutator;


        import com.coxautodev.graphql.tools.GraphQLMutationResolver;
        import com.udacity.graphql.entity.Dog;
        import com.udacity.graphql.exception.DogNotFound;
        import com.udacity.graphql.repository.DogRepository;
        import org.springframework.stereotype.Component;

        import java.util.Optional;

@Component
public class DogMutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public DogMutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    //public void DogMutation(DogRepository dogRepository) { this.dogRepository = dogRepository; }

    public Dog newDog(String name, String breed, String origin)
    {
        Dog dog = new Dog(name, breed, origin);
        this.dogRepository.save(dog);
        return dog;
    }

    public boolean deleteDog(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public Dog updateDogBreed(String breed, Long id) throws DogNotFound {
        Optional<Dog> opDog =
                dogRepository.findById(id);

        if(opDog.isPresent()) {
            Dog dog = opDog.get();
            dog.setBreed(breed);
            dogRepository.save(dog);
            return dog;
        } else {
            System.out.println("no Dog");
            throw new DogNotFound("Dog Not Found", id);
        }
    }


    public Dog updateDogName(String name, Long id) throws DogNotFound {
        Optional<Dog> opDog =
                dogRepository.findById(id);

        if(opDog.isPresent()) {
            Dog dog = opDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            System.out.println("no Dog");
            throw new DogNotFound("Dog Not Found", id);
        }
    }


}

