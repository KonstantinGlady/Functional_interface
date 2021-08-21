package com.company.project1;

import java.util.ArrayList;
import java.util.List;

public class PlayfulPets {

    private static void matchPet(String criteria, PetMatcher matcher, Pet pet) {
        System.out.println("\n" + criteria + ": ");
        System.out.println("First: " + matcher.first(pet));
        System.out.println("All: " + matcher.match(pet));
    }

    public static void main(String[] args) {
        Pet.pets.add(new Pet("May", "cat", "siam", "red", 400.00));
        Pet.pets.add(new Pet("Max", "dog", "poodle", "black", 540.50));
        Pet.pets.add(new Pet("Cuddles", "dog", "pug", "black", 1282.75));
        Pet.pets.add(new Pet("Slider", "snake", "garden", "green", 320.00));
        Pet.pets.add(new Pet("Scruffy", "dog", "poodle", "white", 895.00));

        PetMatcher breedMatcher = new PetMatcher() {
            @Override
            public List<Pet> match(Pet pet) {
                List<Pet> matches = new ArrayList<>();
                for (Pet p : Pet.pets) {
                    if (p.equals(pet)) {
                        matches.add(p);
                    }
                }
                return matches;
            }
        };

        PetMatcher priceMatcher = new PetMatcher() {
            @Override
            public List<Pet> match(Pet pet) {
                List<Pet> matches = new ArrayList<>();
                for (Pet p : Pet.pets) {
                    if (p.getPrice() <= pet.getPrice()) {
                        matches.add(p);
                    }
                }
                return matches;
            }

            @Override
            public Pet first(Pet pet) {
                int index = -1;
                for (Pet p :
                        Pet.pets) {
                    if (p.getPrice() <= pet.getPrice()) {
                        return p;
                    }
                }
                return null;
            }
        };
        matchPet("Poodles", breedMatcher, new Pet(null, "dog", "poodle", null, 0.0));
        matchPet("pets for 800$", priceMatcher, new Pet(null, null, null, null, 800.00));
    }
}
