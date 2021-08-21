package com.company.project1;

import java.util.List;

@FunctionalInterface
interface PetMatcher {

    List<Pet> match(Pet pet);

    default Pet first(Pet pet) {
        int index = Pet.pets.indexOf(pet);
        return index > -1 ? Pet.pets.get(index) : null;
    }
}
