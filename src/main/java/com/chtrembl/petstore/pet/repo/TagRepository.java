package com.chtrembl.petstore.pet.repo;

import com.chtrembl.petstore.pet.dao.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);
}