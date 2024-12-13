package org.example.correctSolutions;

import com.example.domain.Animal;
import com.example.domain.Cat;
import com.example.domain.Fish;
import com.example.domain.Spider;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SolutionExercise26 {
	public static void main(String[] args) {
		// Count the number of species
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		long totalNumberOfSpecies = animals.stream().map(Animal::getClass).map(Class::getSimpleName).distinct().count();
		System.out.println(totalNumberOfSpecies);
	}
}
