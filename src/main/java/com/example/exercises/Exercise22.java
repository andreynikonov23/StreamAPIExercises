package com.example.exercises;


import com.example.domain.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise22 {

	public static void main(String[] args) {
		// Take a list of 100 random animals
		IntStream.range(0, 100).mapToObj(value -> {
			int i = new Random().nextInt(1, 4);
			return switch (i) {
				case 1 -> new Cat();
				case 2 -> new Spider();
				case 3 -> new Fish("Nemo");
				default -> throw new IllegalStateException("Unexpected value: " + i);
			};
		}).toList().forEach(System.out::println);

	}
}
