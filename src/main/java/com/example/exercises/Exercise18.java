package com.example.exercises;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise18 {
	private static final  MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the year where the maximum number of movie is available
		Collection<Movie> movies = movieService.findAllMovies();


		Map.Entry<Integer, Long> result = movies.stream()
				.collect(groupingBy(Movie::getYear, Collectors.counting()))
				.entrySet()
				.stream()
				.max(Comparator.comparing(Map.Entry::getValue)).get();
		System.out.println(result.getKey() + "=" + result.getValue());
	}

}
