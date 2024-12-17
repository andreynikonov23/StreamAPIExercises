package com.example.exercises;

import java.util.Random;
import java.util.stream.IntStream;

import com.example.domain.*;


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
