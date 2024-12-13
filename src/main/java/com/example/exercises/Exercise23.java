package com.example.exercises;

import java.util.Arrays;
import java.util.List;

import com.example.domain.*;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise23 {
	public static void main(String[] args) {
		// Find the total number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		long totalNumOfLegs = animals.stream().mapToLong(Animal::getLegs).sum();
		System.out.println(totalNumOfLegs);
	}
}
