package com.chtrembl.petstore.pet.utils;

import com.chtrembl.petstore.pet.dao.Category;
import com.chtrembl.petstore.pet.dao.Pet;
import com.chtrembl.petstore.pet.dao.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class EntityToModelMapper {

    public static com.chtrembl.petstore.pet.model.Category toModel(Category entity) {
        if (entity == null) {
            return null;
        }
        return com.chtrembl.petstore.pet.model.Category.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static com.chtrembl.petstore.pet.model.Tag toModel(Tag entity) {
        if (entity == null) {
            return null;
        }
        return com.chtrembl.petstore.pet.model.Tag.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static List<com.chtrembl.petstore.pet.model.Tag> toModelTags(List<Tag> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(EntityToModelMapper::toModel)
                .collect(Collectors.toList());
    }

    public static com.chtrembl.petstore.pet.model.Pet toModel(Pet entity) {
        if (entity == null) {
            return null;
        }

        com.chtrembl.petstore.pet.model.Pet.Status status = null;
        if (entity.getStatus() != null) {
            status = com.chtrembl.petstore.pet.model.Pet.Status.fromValue(entity.getStatus());
        }

        return com.chtrembl.petstore.pet.model.Pet.builder()
                .id(entity.getId())
                .name(entity.getName())
                .photoURL(entity.getPhotoURL())
                .category(toModel(entity.getCategory()))
                // tags: add when you have a relation on DAO side
                .status(status)
                .build();
    }
}