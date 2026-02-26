package com.chtrembl.petstore.pet.service;

import com.chtrembl.petstore.pet.model.DataPreload;
import com.chtrembl.petstore.pet.model.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("inMemoryPetService")
@Slf4j
@RequiredArgsConstructor
public class InMemoryPetService implements PetService {

    private final DataPreload dataPreload;

    @Override
    public List<Pet> findPetsByStatus(List<String> status) {
        log.info("Finding pets with status: {}", status);

        return dataPreload.getPets().stream()
                .filter(pet -> status.contains(pet.getStatus().getValue()))
                .toList();
    }

    @Override
    public Optional<Pet> findPetById(Long petId) {
        log.info("Finding pet with id: {}", petId);

        return dataPreload.getPets().stream()
                .filter(pet -> pet.getId().equals(petId))
                .findFirst();
    }

    @Override
    public List<Pet> getAllPets() {
        log.info("Getting all pets");
        return dataPreload.getPets();
    }

    public int getPetCount() {
        return dataPreload.getPets().size();
    }
}