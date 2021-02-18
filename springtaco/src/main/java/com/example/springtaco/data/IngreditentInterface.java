package com.example.springtaco.data;

import com.example.springtaco.entity.Ingredient;

public interface IngreditentInterface {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
