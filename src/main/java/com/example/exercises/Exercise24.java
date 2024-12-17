package com.example.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.example.domain.*;


/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise24 {


	public static void main(String[] args) {
		// Group the animals by their number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		animals.stream().collect(Collectors.groupingBy(Animal::getLegs)).forEach((legs, animal) -> System.out.println(legs + ": " + animal));
	}
}
