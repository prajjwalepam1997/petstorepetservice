package com.chtrembl.petstore.pet.service;

import com.chtrembl.petstore.pet.dao.Pet;
import com.chtrembl.petstore.pet.repo.PetRepository;
import com.chtrembl.petstore.pet.utils.EntityToModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("postgresPetService")
@Slf4j
@RequiredArgsConstructor
public class PostGresPetService implements PetService {

    private final PetRepository petRepository;

    @Override
    public List<com.chtrembl.petstore.pet.model.Pet> findPetsByStatus(List<String> status) {
        log.info("Finding pets with status: {}", status);
        List<Pet> entities = petRepository.findByStatusIn(status);
        return entities.stream()
                .map(EntityToModelMapper::toModel)
                .toList();
    }

    @Override
    public Optional<com.chtrembl.petstore.pet.model.Pet> findPetById(Long petId) {
        log.info("Finding pet with id: {}", petId);
        return petRepository.findById(petId)
                .map(EntityToModelMapper::toModel);
    }

    @Override
    public List<com.chtrembl.petstore.pet.model.Pet> getAllPets() {
        log.info("Getting all pets from PostgreSQL");
        return petRepository.findAll().stream()
                .map(EntityToModelMapper::toModel)
                .toList();
    }

    @Override
    public int getPetCount() {
        return (int) petRepository.count();
    }
}