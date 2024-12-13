package org.example.correctSolutions;


import com.example.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SolutionExercise19 {
	private static final List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"),
			new Fish("Free Willy"), new Spider(), new Fish("Jaws"));
	private static final Predicate<Animal> isPet = Pet.class::isInstance;
	private static final Predicate<Animal> isWild = isPet.negate();

	public static void main(String[] args) {
		// Take a list of wild animals
		List<Animal> wildAnimals = animals.stream().filter(isWild).collect(Collectors.toList());
		wildAnimals.stream().map(Object::getClass).map(Class::getName).distinct().forEach(System.out::println);
	}
}
