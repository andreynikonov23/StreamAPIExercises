package com.example.exercises;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.example.domain.*;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise22 {
	private static final Random random = new SecureRandom();
	private static final Supplier<Animal> spiderCreator = Spider::new;
	private static final Supplier<Animal> catCreator = Cat::new;
	private static final Supplier<Animal> fishCreator = () -> new Fish("Çakıl");
	private static final List<Supplier<Animal>> suppliers = Arrays.asList(spiderCreator, catCreator, fishCreator);

	public static void main(String[] args) {
		// Take a list of 100 random animals
		List<Animal> result = IntStream.range(0, 99).mapToObj(operand -> {
			int a = new Random().nextInt(0, 2);
			return switch (a) {
				case 0 -> new Cat();
				case 1 -> new Fish("Alexey");
				case 2 -> new Spider();
				default -> throw new IllegalStateException("Unexpected value: " + a);
			};
		})
	}
}
