package com.chtrembl.petstore.pet.repo;

import com.chtrembl.petstore.pet.dao.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByStatusIn(List<String> status);
}