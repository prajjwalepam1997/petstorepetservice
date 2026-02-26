package com.chtrembl.petstore.pet.service;

import com.chtrembl.petstore.pet.model.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
     List<Pet> findPetsByStatus(List<String> status);
     Optional<Pet> findPetById(Long petId);
     List<Pet> getAllPets();
     int getPetCount();
}
