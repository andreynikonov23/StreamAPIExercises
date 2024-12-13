package com.example.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.domain.*;
/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise20 {
	private static final List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"),
			new Fish("Free Willy"), new Spider(), new Fish("Jaws"));

	public static void main(String[] args) {
		// Take a list of pets
		animals.stream().filter(animal -> {
			Class<? extends Animal> animalClass = animal.getClass();
			return Pet.class.isAssignableFrom(animalClass);
		}).map(Animal::getClass).distinct().forEach(aClass -> System.out.println(aClass.getName()));
	}
}
