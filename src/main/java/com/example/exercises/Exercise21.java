package com.example.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.example.domain.*;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise21 {

	public static void main(String[] args) {
		// Find the animal with the highest number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		Animal animal = animals.stream().max(Comparator.comparingInt(Animal::getLegs)).get();
		System.out.println(animal.getClass().getSimpleName() + " with " + animal.getLegs() + " legs.");
	}

}
