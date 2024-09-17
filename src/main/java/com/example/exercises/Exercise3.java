package com.example.exercises;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of genres of each director's movies
		Collection<Movie> movies = movieService.findAllMovies();

		Map<Director, Long> result = movies.stream().map(movie -> movie.getDirectors().stream()
				.map(dir -> new DirectorGenresPair(dir,
						movie.getGenres().stream().
								filter(x -> movie.getDirectors()
										.contains(dir)).collect(Collectors.toList()))
				).collect(Collectors.toList()))
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(DirectorGenresPair::director, Collectors.counting()));
		result.forEach((dir, count) -> System.out.println(dir.getName() + " - " + count));
	}
}