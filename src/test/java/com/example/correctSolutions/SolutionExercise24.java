package org.example.correctSolutions;

import com.example.domain.Animal;
import com.example.domain.Cat;
import com.example.domain.Fish;
import com.example.domain.Spider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SolutionExercise24 {
	private static final BiConsumer<Integer, List<Animal>> printGroup = (count, list) -> System.out
			.println(count + ": " + list);

	public static void main(String[] args) {
		// Group the animals by their number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		Map<Integer, List<Animal>> groupedAnimals = animals.stream().collect(Collectors.groupingBy(Animal::getLegs));
		groupedAnimals.forEach(printGroup);
	}
}
