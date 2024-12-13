package com.example.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.example.domain.*;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise25 {
	private static final BiConsumer<Class<?>, Long> printGroup = (clazz, count) -> System.out
			.println(clazz.getSimpleName() + ": " + count);

	public static void main(String[] args) {
		// Count the number of animals in each species
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		Map<Class<?>, Long> groupedAnimals = animals.stream()
				.collect(Collectors.groupingBy(Animal::getClass, Collectors.counting()));
		groupedAnimals.forEach(printGroup);
	}
}
