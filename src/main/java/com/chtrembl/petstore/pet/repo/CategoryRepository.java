package com.chtrembl.petstore.pet.repo;

import com.chtrembl.petstore.pet.dao.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
