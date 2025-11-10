package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

@Value("${course.name}")
private String courseName;

@Value("${project.developer.fullname}")
private String developerName;

private Map<Integer, Animal> animals = new HashMap<>();

public AnimalController(){

    animals.put(1,new Animal(1,"Lion"));
    animals.put(2,new Animal(2,"Tiger"));

}
@GetMapping("/animal")
public List<Animal> getAllAnimals(){
    System.out.println("Course: " + courseName + ", Developer: " + developerName);
    return new ArrayList<>(animals.values());
}

@GetMapping("/animal/{id}")
public Animal getAnimalById(@PathVariable int id){
    return animals.get(id);
}

@PostMapping("/animal")
public Animal addAnimal(@RequestBody Animal newAnimal){
    animals.put(newAnimal.getId(), newAnimal);
    return newAnimal;

}

@PutMapping("/animal/{id}")
public Animal updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
    animals.put(id, updatedAnimal);
    return updatedAnimal;
}

@DeleteMapping("/animal/{id}")
public String deleteAnimal(@PathVariable int id){
    animals.remove(id);
    return "Animal with id " + id + " deleted." ;
}


}
