package com.example.exercises;

import java.util.Collection;
import java.util.List;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise7 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the list of movies having the genres "Drama" and "Comedy" only
		Collection<Movie> movies = movieService.findAllMovies();

		movies.stream()
				.filter(movie -> movie.getGenres().size() == 2)
				.filter(movie -> movie.getGenres().get(0).getName().equals("Drama") && movie.getGenres().get(1).getName().equals("Comedy")
						|| movie.getGenres().get(0).getName().equals("Comedy") && movie.getGenres().get(1).getName().equals("Drama"))
				.toList()
				.forEach(movie -> System.out.printf("%s %s\n", movie, movie.getGenres()));

	}

}
